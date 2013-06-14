package com.sergiandreplace.recordsbox.content;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.sergiandreplace.recordsbox.content.base.MinionContentProvider;
import com.sergiandreplace.recordsbox.database.DatabaseContract;

/**
 * Created with IntelliJ IDEA.
 * User: Sergi
 * Date: 31/05/13
 * Time: 02:04
 * To change this template use File | Settings | File Templates.
 */
public class TracksContentProvider implements MinionContentProvider {
    @Override
    public String getBasePath() {
        return ContentContract.TracksCursor.PATH_ITEM;
    }


    @Override
    public Cursor query(SQLiteDatabase db, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return db.query(DatabaseContract.TracksTable.TABLE_NAME, projection, selection, selectionArgs, sortOrder, null, null);
    }

    @Override
    public long insert(SQLiteDatabase db, Uri uri, ContentValues contentValues) {

        return db.insert(DatabaseContract.TracksTable.TABLE_NAME, "", contentValues);
    }

    @Override
    public int delete(SQLiteDatabase db, Uri uri, String where, String[] selectionArgs) {
        return db.delete(DatabaseContract.TracksTable.TABLE_NAME, where, selectionArgs);
    }

    @Override
    public int update(SQLiteDatabase db, Uri uri, ContentValues values, String where, String[] selectionArgs) {
        return db.update(DatabaseContract.TracksTable.TABLE_NAME, values, where, selectionArgs);
    }

    @Override
    public String getType() {
        return ContentContract.TracksCursor.CONTENT_TYPE_ITEM;
    }
}
