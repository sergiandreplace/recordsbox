package com.sergiandreplace.recordsbox.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sergiandreplace.recordsbox.database.DatabaseContract.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sergi
 * Date: 31/05/13
 * Time: 02:06
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(Context context) {
        super(context, DatabaseContract.DATABASE_NAME, null, DatabaseContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createEventsTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    private void createEventsTable(SQLiteDatabase db) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ").append(TracksTable.TABLE_NAME).append(" (").
                append(TracksTable.Columns._ID).append(" TEXT PRIMARY KEY, ").
                append(TracksTable.Columns.ALBUM_TITLE).append(" TEXT, ").
                append(TracksTable.Columns.ALBUM_ARTIST).append(" TEXT, ").
                append(TracksTable.Columns.ARTIST).append(" TEXT, ").
                append(TracksTable.Columns.TRACK_TITLE).append(" TEXT, ").
                append(TracksTable.Columns.COVERT_ART_URL).append(" TEXT, ").
                append(TracksTable.Columns.ALBUM_RELEASE_YEAR).append(" TEXT, ").
                append(TracksTable.Columns.ALBUM_TRACK_COUNT).append(" NUMBER, ").
                append(TracksTable.Columns.TRACK_NUMBER).append(" NUMBER, ").
                append(TracksTable.Columns.GENRE_ID).append(" TEXT, ").
                append(TracksTable.Columns.GENRE).append(" TEXT, ").
                append(TracksTable.Columns.SONG_POSITION).append(" NUMBER, ").
                append(TracksTable.Columns.ALBUM_REVIEW_URL).append(" TEXT, ").
                append(TracksTable.Columns.ARTIST_BIOGRAPHY_URL).append(" TEXT, ").
                append(TracksTable.Columns.ALBUM_ID).append(" TEXT, ").
                append(TracksTable.Columns.ARTIST_IMAGE_URL).append(" TEXT)");

        db.execSQL(sb.toString());
    }
}