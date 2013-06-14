package com.sergiandreplace.recordsbox.cusor;

import android.content.ContentValues;
import android.database.Cursor;
import com.sergiandreplace.recordsbox.bean.Track;
import com.sergiandreplace.recordsbox.content.ContentContract.TracksCursor.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sergi
 * Date: 31/05/13
 * Time: 02:40
 * To change this template use File | Settings | File Templates.
 */
public class TracksCursorHelper extends BaseCursorHelper<Track> {

    /**
     * Stores an Event objet into a content value
     * @param track
     * @return
     */
    public ContentValues setValues(Track track) {
        ContentValues values=new ContentValues();
        values.put(Columns._ID, track.getTrackId());
        values.put(Columns.ALBUM_TITLE, track.getAlbumTitle());
        values.put(Columns.ALBUM_ARTIST, track.getAlbumArtist());
        values.put(Columns.ARTIST, track.getArtist());
        values.put(Columns.TRACK_TITLE, track.getTrackTitle());
        values.put(Columns.COVERT_ART_URL, track.getCoverArtUrl());
        values.put(Columns.ALBUM_ID, track.getAlbumId());
        values.put(Columns.ALBUM_RELEASE_YEAR, track.getAlbumReleaseYear());
        values.put(Columns.ALBUM_TRACK_COUNT, track.getAlbumTrackCount());
        values.put(Columns.TRACK_NUMBER, track.getTrackNumber());
        values.put(Columns.GENRE_ID, track.getGenreId());
        values.put(Columns.GENRE, track.getGenre());
        values.put(Columns.SONG_POSITION, track.getSongPosition());
        values.put(Columns.ALBUM_REVIEW_URL, track.getAlbumReviewUrl());
        values.put(Columns.ARTIST_BIOGRAPHY_URL, track.getArtistBiographyUrl());
        values.put(Columns.ARTIST_IMAGE_URL, track.getArtistImageUrl());



        return values;
    }

    /**
     * Reads a cursor and deserializes to an event object
     * @param cursor the cursor positioned in the record to extract
     * @return An event representing the record
     */
    public Track readCursor (Cursor cursor) {
        Track track=new Track();
        track.setTrackId(cursor.getString(cursor.getColumnIndex(Columns._ID)));
        track.setAlbumTitle(cursor.getString(cursor.getColumnIndex(Columns.ALBUM_TITLE)));
        track.setAlbumArtist(cursor.getString(cursor.getColumnIndex(Columns.ALBUM_ARTIST)));
        track.setArtist(cursor.getString(cursor.getColumnIndex(Columns.ARTIST)));
        track.setTrackTitle(cursor.getString(cursor.getColumnIndex(Columns.TRACK_TITLE)));
        track.setCoverArtUrl(cursor.getString(cursor.getColumnIndex(Columns.COVERT_ART_URL)));
        track.setAlbumId(cursor.getString(cursor.getColumnIndex(Columns.ALBUM_ID)));
        track.setAlbumReleaseYear(cursor.getString(cursor.getColumnIndex(Columns.ALBUM_RELEASE_YEAR)));
        track.setAlbumTrackCount(cursor.getInt(cursor.getColumnIndex(Columns.ALBUM_TRACK_COUNT)));
        track.setTrackNumber(cursor.getInt(cursor.getColumnIndex(Columns.TRACK_NUMBER)));
        track.setGenreId(cursor.getString(cursor.getColumnIndex(Columns.GENRE_ID)));
        track.setGenre(cursor.getString(cursor.getColumnIndex(Columns.GENRE)));
        track.setSongPosition(cursor.getString(cursor.getColumnIndex(Columns.SONG_POSITION)));
        track.setAlbumReviewUrl(cursor.getString(cursor.getColumnIndex(Columns.ALBUM_REVIEW_URL)));
        track.setArtistBiographyUrl(cursor.getString(cursor.getColumnIndex(Columns.ARTIST_BIOGRAPHY_URL)));
        track.setArtistImageUrl(cursor.getString(cursor.getColumnIndex(Columns.ARTIST_IMAGE_URL)));
        return track;
    }




}
