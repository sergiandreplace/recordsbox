package com.sergiandreplace.recordsbox.content;

import android.database.sqlite.SQLiteDatabase;
import com.sergiandreplace.recordsbox.content.base.DespicableContentProvider;
import com.sergiandreplace.recordsbox.content.base.SimpleItemMinionContentProvider;
import com.sergiandreplace.recordsbox.content.base.SimpleMinionContentProvider;
import com.sergiandreplace.recordsbox.database.DatabaseContract.*;
import com.sergiandreplace.recordsbox.content.ContentContract.*;
import com.sergiandreplace.recordsbox.database.DatabaseHelper;


/**
 * Created with IntelliJ IDEA.
 * User: Sergi
 * Date: 31/05/13
 * Time: 02:34
 * To change this template use File | Settings | File Templates.
 */
public class RecordsBoxContentProvider extends DespicableContentProvider {
    private SQLiteDatabase db;

    @Override
    public void recruitMinions() {
        addMinion(new SimpleMinionContentProvider(ContentContract.TracksCursor.PATH_DIR, TracksTable.TABLE_NAME, TracksCursor.CONTENT_TYPE_DIR));
        //addMinion(new SimpleItemMinionContentProvider(ContentContract.TracksCursor.PATH_ITEM, TracksTable.TABLE_NAME, TracksCursor.CONTENT_TYPE_ITEM));
    }

    @Override
    public String getAuthority() {
        return ContentContract.AUTHORITY;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public SQLiteDatabase getDb() {
        if (db == null) {
            db = new DatabaseHelper(getContext()).getReadableDatabase();
        }
        return db;
    }
}
