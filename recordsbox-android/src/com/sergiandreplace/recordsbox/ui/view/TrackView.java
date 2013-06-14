package com.sergiandreplace.recordsbox.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.androidquery.AQuery;
import com.sergiandreplace.recordsbox.R;
import com.sergiandreplace.recordsbox.bean.Track;


/**
 * Created with IntelliJ IDEA.
 * User: Sergi
 * Date: 13/06/13
 * Time: 17:16
 * To change this template use File | Settings | File Templates.
 */
public class TrackView extends LinearLayout{
    private Context context;
    private ImageView trackAlbumCover;
    private TextView trackTitle;
    private TextView trackArtist;
    private TextView trackAlbumTitle;
    private TextView trackAlbumReleaseYear;
    private TextView trackPosition;
    public TrackView(Context context) {
        super(context);
        init(context);
    }

    public TrackView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TrackView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        this.context=context;
        LayoutInflater inflater= LayoutInflater.from(context);
        inflater.inflate(R.layout.track,this,true);
        findViews();
    }

    private void findViews() {
        trackAlbumCover = (ImageView)findViewById( R.id.trackAlbumCover );
        trackTitle = (TextView)findViewById( R.id.trackTitle );
        trackArtist = (TextView)findViewById( R.id.trackArtist );
        trackAlbumTitle = (TextView)findViewById( R.id.trackAlbumTitle );
        trackAlbumReleaseYear = (TextView)findViewById( R.id.trackAlbumReleaseYear);
        trackPosition = (TextView)findViewById( R.id.trackPosition );
    }

    public void setTrack(Track track) {
        trackTitle.setText(track.getTrackTitle());
        trackArtist.setText(track.getArtist());
        trackAlbumTitle.setText(track.getAlbumTitle());
        trackAlbumReleaseYear.setText(track.getAlbumReleaseYear());
        trackPosition.setText(String.format("%s of %s", track.getTrackNumber(),track.getAlbumTrackCount()));
        AQuery aq=new AQuery(this);
        aq.id(trackAlbumCover).progress(R.id.trackAlbumCoverProgress)
                .image(track.getCoverArtUrl(), true, true, 0, R.drawable.ic_album, null, AQuery.FADE_IN);
    }
}
