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
public class SimpleMinionContentProvider implements MinionContentProvider {

    private final String basePath;
    private final String tableName;
    private final String type;

    public SimpleMinionContentProvider(String basePath, String tableName, String type){
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
        return db.query(tableName, projection, selection, selectionArgs, sortOrder, null, null);
    }

    @Override
    public long insert(SQLiteDatabase db, Uri uri, ContentValues contentValues) {

        return db.insert(tableName, "", contentValues);
    }

    @Override
    public int delete(SQLiteDatabase db, Uri uri, String where, String[] selectionArgs) {
        return db.delete(tableName, where, selectionArgs);
    }

    @Override
    public int update(SQLiteDatabase db, Uri uri, ContentValues values, String where, String[] selectionArgs) {
        return db.update(tableName, values, where, selectionArgs);
    }

    @Override
    public String getType() {
        return type;
    }
}
