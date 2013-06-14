package com.sergiandreplace.recordsbox.ui.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.gracenote.mmid.MobileSDK.*;
import com.sergiandreplace.recordsbox.R;
import com.sergiandreplace.recordsbox.bean.Track;
import com.sergiandreplace.recordsbox.bean.TrackFactory;
import com.sergiandreplace.recordsbox.ui.view.HoloCircularProgressBar;
import com.sergiandreplace.recordsbox.ui.view.TrackView;

public class SongSearchFoundFragment extends Fragment implements View.OnClickListener {
    private TrackView songFoundTrack;
    private Button songFoundKeep;
    private Button songFoundBack;
    View currentView;

    private OnFoundActionListener onFoundActionListener;
    private Track track;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        currentView = inflater.inflate(R.layout.song_search_found,container,false);
        findViews();
        setListeners();
        songFoundTrack.setTrack(track);
        return currentView;
    }

    public void setTrack (Track track) {
        this.track=track;

    }

    private void setListeners() {
        songFoundKeep.setOnClickListener(this);
        songFoundBack.setOnClickListener(this);
    }

    private void findViews() {
        songFoundTrack = (TrackView)currentView.findViewById(R.id.songFoundTrack);
        songFoundKeep = (Button)currentView.findViewById(R.id.songFoundKeep);
        songFoundBack = (Button)currentView.findViewById(R.id.songFoundBack);


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == songFoundBack.getId()) {
            if (onFoundActionListener!=null) {
                onFoundActionListener.onSongFoundBack();
            }
        }

        if (view.getId() == songFoundKeep.getId()) {
            if (onFoundActionListener!=null) {
                onFoundActionListener.onSongFoundKeep();
            }
        }
    }

    public OnFoundActionListener getOnFoundActionListener() {
        return onFoundActionListener;
    }

    public void setOnFoundActionListener(OnFoundActionListener onFoundActionListener) {
        this.onFoundActionListener = onFoundActionListener;
    }

    public interface OnFoundActionListener {
        public void onSongFoundBack();
        public void onSongFoundKeep();
    }
}
