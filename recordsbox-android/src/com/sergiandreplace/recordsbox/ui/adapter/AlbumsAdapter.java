package com.sergiandreplace.recordsbox.ui.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.androidquery.AQuery;
import com.sergiandreplace.recordsbox.R;
import com.sergiandreplace.recordsbox.bean.Album;
import com.sergiandreplace.recordsbox.cusor.AlbumsCursorHelper;

/**
 * Created with IntelliJ IDEA.
 * User: Sergi
 * Date: 14/06/13
 * Time: 11:51
 * To change this template use File | Settings | File Templates.
 */
public class AlbumsAdapter extends CursorAdapter {
    AQuery aq;
    /**
     * ViewHolder class for layout.<br />
     * <br />
     * Auto-created on 2013-06-14 11:50:43 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private static class ViewHolder {
        public final TextView albumTitle;
        public final TextView albumArtist;
        public final ImageView albumCover;
        public final ProgressBar albumCoverProgress;
        public final TextView albumReleaseYear;
        public final TextView albumTracks;

        private ViewHolder(TextView albumTitle, TextView albumArtist, ImageView albumCover, ProgressBar albumCoverProgress, TextView AlbumReleaseYear, TextView albumTracks) {
            this.albumTitle = albumTitle;
            this.albumArtist = albumArtist;
            this.albumCover = albumCover;
            this.albumCoverProgress = albumCoverProgress;
            this.albumReleaseYear = AlbumReleaseYear;
            this.albumTracks = albumTracks;
        }

        public static ViewHolder create(LinearLayout rootView) {
            TextView albumTitle = (TextView)rootView.findViewById( R.id.albumTitle );
            TextView albumArtist = (TextView)rootView.findViewById( R.id.albumArtist );
            ImageView albumCover = (ImageView)rootView.findViewById( R.id.albumCover );
            ProgressBar albumCoverProgress = (ProgressBar)rootView.findViewById( R.id.albumCoverProgress );
            TextView AlbumReleaseYear = (TextView)rootView.findViewById( R.id.AlbumReleaseYear );
            TextView albumTracks = (TextView)rootView.findViewById( R.id.albumTracks );
            return new ViewHolder( albumTitle, albumArtist, albumCover, albumCoverProgress, AlbumReleaseYear, albumTracks );
        }
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        final ViewHolder vh = (ViewHolder)view.getTag();

        Album album= new AlbumsCursorHelper().readCursor(cursor);
        vh.albumArtist.setText(album.getAlbumArtist());
        vh.albumTitle.setText(album.getAlbumTitle());
        vh.albumReleaseYear.setText(album.getAlbumReleaseYear());
        vh.albumTracks.setText(String.format("%d out of %d",album.getTracks(), album.getAlbumTrackCount()));
        aq.id(vh.albumCover).progress(vh.albumCoverProgress)
                .image(album.getCoverArtUrl(), true, true, 0, R.drawable.ic_album, null, AQuery.FADE_IN);

    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = mInflater.inflate( R.layout.album_item, parent, false );
        view.setTag( ViewHolder.create( (LinearLayout)view ) );
        return view;
    }

    private LayoutInflater mInflater;

    // Constructors
    public AlbumsAdapter(Context context) {
        super(context, null, true);
        this.mInflater = LayoutInflater.from( context );
        aq=new AQuery(context);
    }
    public AlbumsAdapter(Context context, Cursor c) {
        super(context, c, true);
        this.mInflater = LayoutInflater.from( context );
        aq=new AQuery(context);
    }
}

