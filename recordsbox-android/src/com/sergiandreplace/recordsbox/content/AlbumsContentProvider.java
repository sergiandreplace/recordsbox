package com.sergiandreplace.recordsbox.content;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
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
public class AlbumsContentProvider implements MinionContentProvider {
    @Override
    public String getBasePath() {
        return ContentContract.AlbumsCursor.PATH_DIR;
    }


    @Override
    public Cursor query(SQLiteDatabase db, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder qb=new SQLiteQueryBuilder();
        String[] columns= new String[] {

                DatabaseContract.TracksTable.Columns.ALBUM_TITLE,
                DatabaseContract.TracksTable.Columns.ALBUM_ARTIST,
                "MIN (" + DatabaseContract.TracksTable.Columns.COVERT_ART_URL + ") AS " + DatabaseContract.TracksTable.Columns.COVERT_ART_URL,
                DatabaseContract.TracksTable.Columns.ALBUM_ID + " AS " + ContentContract.AlbumsCursor.Columns._ID,
                DatabaseContract.TracksTable.Columns.ALBUM_RELEASE_YEAR,
                DatabaseContract.TracksTable.Columns.ALBUM_TRACK_COUNT,
                "COUNT("+DatabaseContract.TracksTable.Columns.TRACK_NUMBER+") AS " + ContentContract.AlbumsCursor.Columns.TRACKS,
                DatabaseContract.TracksTable.Columns.ALBUM_REVIEW_URL
        };
        StringBuilder groupBy=new StringBuilder();
        groupBy.append(DatabaseContract.TracksTable.Columns.ALBUM_TITLE).append(", ")
            .append(DatabaseContract.TracksTable.Columns.ALBUM_ARTIST).append(", ")
            .append(ContentContract.AlbumsCursor.Columns._ID).append(", ")
            .append(DatabaseContract.TracksTable.Columns.ALBUM_RELEASE_YEAR).append(", ")
            .append(DatabaseContract.TracksTable.Columns.ALBUM_TRACK_COUNT).append(", ")
            .append(DatabaseContract.TracksTable.Columns.ALBUM_REVIEW_URL);

        qb.setTables(DatabaseContract.TracksTable.TABLE_NAME);
        return qb.query(db,columns,  selection, selectionArgs, groupBy.toString(), null, sortOrder);
//        return db.query(DatabaseContract.TracksTable.TABLE_NAME,projection,selection,selectionArgs,null,null,sortOrder) ;
    }

    @Override
    public long insert(SQLiteDatabase db, Uri uri, ContentValues contentValues) {

        throw new UnsupportedOperationException();
    }

    @Override
    public int delete(SQLiteDatabase db, Uri uri, String where, String[] selectionArgs) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int update(SQLiteDatabase db, Uri uri, ContentValues values, String where, String[] selectionArgs) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getType() {
        return ContentContract.AlbumsCursor.CONTENT_TYPE_ITEM;
    }
}
