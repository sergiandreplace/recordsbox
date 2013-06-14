package com.sergiandreplace.recordsbox.cusor;

import android.content.ContentValues;
import android.database.Cursor;
import com.sergiandreplace.recordsbox.bean.Album;
import com.sergiandreplace.recordsbox.bean.Track;
import com.sergiandreplace.recordsbox.content.ContentContract.AlbumsCursor.Columns;

/**
 * Created with IntelliJ IDEA.
 * User: Sergi
 * Date: 31/05/13
 * Time: 02:40
 * To change this template use File | Settings | File Templates.
 */
public class AlbumsCursorHelper extends BaseCursorHelper<Album> {

    /**
     * Stores an Event objet into a content value
     * @param album
     * @return
     */
    public ContentValues setValues(Album album) {
        ContentValues values=new ContentValues();
        values.put(Columns._ID, album.getAlbumId());
        values.put(Columns.ALBUM_TITLE, album.getAlbumTitle());
        values.put(Columns.ALBUM_ARTIST, album.getAlbumArtist());
        values.put(Columns.COVERT_ART_URL, album.getCoverArtUrl());
        values.put(Columns.ALBUM_ID, album.getAlbumId());
        values.put(Columns.ALBUM_RELEASE_YEAR, album.getAlbumReleaseYear());
        values.put(Columns.ALBUM_TRACK_COUNT, album.getAlbumTrackCount());
        values.put(Columns.ALBUM_REVIEW_URL, album.getAlbumReviewUrl());



        return values;
    }

    /**
     * Reads a cursor and deserializes to an event object
     * @param cursor the cursor positioned in the record to extract
     * @return An event representing the record
     */
    public Album readCursor (Cursor cursor) {
        Album album=new Album();
        album.setAlbumId(cursor.getString(cursor.getColumnIndex(Columns._ID)));
        album.setAlbumTitle(cursor.getString(cursor.getColumnIndex(Columns.ALBUM_TITLE)));
        album.setAlbumArtist(cursor.getString(cursor.getColumnIndex(Columns.ALBUM_ARTIST)));
        album.setCoverArtUrl(cursor.getString(cursor.getColumnIndex(Columns.COVERT_ART_URL)));
        album.setAlbumReleaseYear(cursor.getString(cursor.getColumnIndex(Columns.ALBUM_RELEASE_YEAR)));
        album.setAlbumTrackCount(cursor.getInt(cursor.getColumnIndex(Columns.ALBUM_TRACK_COUNT)));
        album.setAlbumReviewUrl(cursor.getString(cursor.getColumnIndex(Columns.ALBUM_REVIEW_URL)));
        album.setTracks(cursor.getInt(cursor.getColumnIndex(Columns.TRACKS)));
        return album;
    }




}
