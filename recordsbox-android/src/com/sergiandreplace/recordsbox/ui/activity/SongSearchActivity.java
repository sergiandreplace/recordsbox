package com.sergiandreplace.recordsbox.ui.activity;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.gracenote.mmid.MobileSDK.*;
import com.sergiandreplace.recordsbox.R;
import com.sergiandreplace.recordsbox.bean.Track;
import com.sergiandreplace.recordsbox.content.ContentContract;
import com.sergiandreplace.recordsbox.cusor.TracksCursorHelper;
import com.sergiandreplace.recordsbox.ui.fragment.SongSearchFoundFragment;
import com.sergiandreplace.recordsbox.ui.fragment.SongSearchRecognitionFragment;
import com.sergiandreplace.recordsbox.ui.view.HoloCircularProgressBar;

public class SongSearchActivity extends Activity implements SongSearchRecognitionFragment.OnTrackFoundListener, SongSearchFoundFragment.OnFoundActionListener {

    private SongSearchRecognitionFragment songSearchRecognitionFragment;
    private Track track;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_search);
        songSearchRecognitionFragment=new SongSearchRecognitionFragment();
        songSearchRecognitionFragment.setOnTrackFoundListener(this);
        FragmentTransaction ft=getFragmentManager().beginTransaction();
        ft.replace(R.id.songSearchFragment, songSearchRecognitionFragment);
        ft.commit();

    }



    @Override
    public void onTrackFound(Track track) {
        this.track=track;
        FragmentTransaction ft=getFragmentManager().beginTransaction();
        SongSearchFoundFragment songSearchFoundFragment=new SongSearchFoundFragment();
        songSearchFoundFragment.setTrack(track);
        songSearchFoundFragment.setOnFoundActionListener(this);
        ft.replace(R.id.songSearchFragment, songSearchFoundFragment);
        ft.addToBackStack(null);
        //ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    @Override
    public void onSongFoundBack() {
        getFragmentManager().popBackStack();
    }

    @Override
    public void onSongFoundKeep() {
        ContentValues values=new TracksCursorHelper().setValues(track);
        getContentResolver().insert(ContentContract.TracksCursor.CONTENT_URI_DIR, values);
        getContentResolver().notifyChange(ContentContract.AlbumsCursor.CONTENT_URI_DIR, null);
        finish();    }
}
