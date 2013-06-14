package com.sergiandreplace.recordsbox.content.base;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * Created with IntelliJ IDEA.
 * User: Sergi
 * Date: 31/05/13
 * Time: 03:13
 * To change this template use File | Settings | File Templates.
 */
public class SimpleItemMinionContentProvider implements MinionContentProvider {

    private final String basePath;
    private final String tableName;
    private final String type;

    public SimpleItemMinionContentProvider(String basePath, String tableName, String type){
        this.basePath=basePath;
        this.tableName=tableName;
        this.type=type;
    }
    @Override
    public String getBasePath() {
        return basePath;
    }
    
    
    @Override
    public Cursor query(SQLiteDatabase db, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        String[] idArgs=new String[] {uri.getLastPathSegment()};
        return db.query(tableName, projection, "_id=?", idArgs, sortOrder, null, null);
    }

    @Override
    public long insert(SQLiteDatabase db, Uri uri, ContentValues contentValues) {

        throw new UnsupportedOperationException();
    }

    @Override
    public int delete(SQLiteDatabase db, Uri uri, String where, String[] selectionArgs) {
        String[] idArgs=new String[] {uri.getLastPathSegment()};
        return db.delete(tableName, "_id=?", idArgs);
    }

    @Override
    public int update(SQLiteDatabase db, Uri uri, ContentValues values, String where, String[] selectionArgs) {
        String[] idArgs=new String[] {uri.getLastPathSegment()};
        return db.update(tableName, values, "_id=?", idArgs);
    }

    @Override
    public String getType() {
        return type;
    }
}
