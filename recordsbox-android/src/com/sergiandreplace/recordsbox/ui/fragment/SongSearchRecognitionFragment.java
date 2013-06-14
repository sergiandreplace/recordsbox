package com.sergiandreplace.recordsbox.ui.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.gracenote.mmid.MobileSDK.*;
import com.sergiandreplace.recordsbox.R;
import com.sergiandreplace.recordsbox.bean.Track;
import com.sergiandreplace.recordsbox.bean.TrackFactory;
import com.sergiandreplace.recordsbox.ui.activity.SongSearchActivity;
import com.sergiandreplace.recordsbox.ui.view.HoloCircularProgressBar;

public class SongSearchRecognitionFragment extends Fragment implements GNSearchResultReady, GNOperationStatusChanged {
    private HoloCircularProgressBar catchSongProgressBar;
    private ImageView catchSongStatusIcon;
    private TextView catchSongStatus;
    private Animation fadeInAnimation, fadeOutAnimation;
    private GNStatusEnum previousStatus=GNStatusEnum.IDLE;
    View currentView;
    private OnTrackFoundListener onTrackFoundListener;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        currentView = inflater.inflate(R.layout.song_search_recognition,container,false);
        findViews();
        initProcess();
        return currentView;
    }

    private void findViews() {
        catchSongProgressBar=(HoloCircularProgressBar) currentView.findViewById(R.id.catchSongProgressBar);
        catchSongStatusIcon=(ImageView) currentView.findViewById(R.id.catchSongStatusIcon);
        catchSongStatus=(TextView) currentView.findViewById(R.id.catchSongStatus);
        fadeInAnimation=AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);
        fadeOutAnimation=AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out);
    }

    private void initProcess() {
        Context applicationContext;
        GNConfig config;
        catchSongProgressBar.setVisibility(View.INVISIBLE);
        catchSongStatusIcon.setVisibility(View.INVISIBLE);
        catchSongStatus.setVisibility(View.INVISIBLE) ;

        applicationContext = getActivity().getApplicationContext();
        config = GNConfig.init("4781312-9230AB93528A702AB013E1109A8B37DB", applicationContext);
        config.setProperty("content.coverArt","true");
        config.setProperty("content.coverArt.sizePreference","MEDIUM");
        GNOperations.recognizeMIDStreamFromMic(this,config);
    }

    @Override
    public void GNResultReady(GNSearchResult gnSearchResult) {
        if (gnSearchResult!=null && gnSearchResult.getBestResponse()!=null) {
            Log.d("GNSTATUS",gnSearchResult.getBestResponse().getAlbumTitle() + " - " + gnSearchResult.getBestResponse().getTrackTitle());
            hideView(catchSongStatusIcon);
            hideView(catchSongStatus);
            Track track= TrackFactory.getTrack(gnSearchResult.getBestResponse());
            if (onTrackFoundListener!=null) {
                onTrackFoundListener.onTrackFound(track);
            }
        }
    }

    @Override
    public void GNStatusChanged(GNStatus gnStatus) {
        if (gnStatus!=null) {
            if (gnStatus.getStatus()==GNStatusEnum.IDLE) {
                catchSongStatusIcon.setVisibility(View.GONE);
                catchSongStatus.setVisibility(View.GONE) ;
            }else if (previousStatus==GNStatusEnum.IDLE){
                showView(catchSongStatusIcon);
                showView(catchSongStatus);
            }
            if (gnStatus.getStatus()==GNStatusEnum.RECORDING) {
                catchSongStatusIcon.setImageResource(R.drawable.ic_speaker);
                catchSongStatus.setText("Carefully listening");
                if (previousStatus!=GNStatusEnum.RECORDING) {
                    showView(catchSongProgressBar);
                }


            } else if (gnStatus.getStatus()==GNStatusEnum.WEBSERVICES) {
                catchSongStatusIcon.setImageResource(R.drawable.ic_cloud);
                catchSongStatus.setText("Looking in the cloud");
                }
            if (previousStatus==GNStatusEnum.RECORDING && gnStatus.getStatus()!=GNStatusEnum.RECORDING) {
                hideView(catchSongProgressBar);
            }
            catchSongProgressBar.setProgress(gnStatus.getPercentDone()/100f);
            Log.d("GNSTATUS", gnStatus.getStatus().toString());
            Log.d("GNSTATUS", gnStatus.getMessage()+"");
            previousStatus=gnStatus.getStatus();

        }
    }

    private void showView(View v) {
        v.setVisibility(View.VISIBLE);
        v.startAnimation(fadeInAnimation);
    }

    private void hideView(View v) {
        v.startAnimation(fadeOutAnimation);
    }

    public OnTrackFoundListener getOnTrackFoundListener() {
        return onTrackFoundListener;
    }

    public void setOnTrackFoundListener(OnTrackFoundListener onTrackFoundListener) {
        this.onTrackFoundListener = onTrackFoundListener;
    }




    public interface OnTrackFoundListener {
        public void onTrackFound(Track track);
    }
}
