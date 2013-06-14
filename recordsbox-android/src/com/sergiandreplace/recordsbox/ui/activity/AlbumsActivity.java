package com.sergiandreplace.recordsbox.ui.activity;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.sergiandreplace.recordsbox.R;
import com.sergiandreplace.recordsbox.content.ContentContract;
import com.sergiandreplace.recordsbox.ui.adapter.AlbumsAdapter;
import com.sergiandreplace.recordsbox.util.DatabaseUtil;

/**
 * Created with IntelliJ IDEA.
 * User: Sergi
 * Date: 14/06/13
 * Time: 12:06
 * To change this template use File | Settings | File Templates.
 */
public class AlbumsActivity extends Activity implements LoaderManager.LoaderCallbacks<Cursor>,View.OnClickListener {
    private ListView albumsList;
    private View albumsCapture;
    private AlbumsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.albums);
        DatabaseUtil.backupDatabase(this,"recordsbox.db");

        albumsList=(ListView) findViewById(R.id.albumsList);
        albumsCapture=findViewById(R.id.albumsCapture);

        albumsCapture.setOnClickListener(this);

        adapter=new AlbumsAdapter(this);
        albumsList.setAdapter(adapter);
        LoaderManager lm = getLoaderManager();

        lm.initLoader(1, null, this);

    }



    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this, ContentContract.AlbumsCursor.CONTENT_URI_DIR, null, null, null, null);

    }

    @Override
    public void onLoadFinished(Loader<Cursor> objectLoader, Cursor cursor) {
        adapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> objectLoader) {
        adapter.swapCursor(null);
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this, SongSearchActivity.class));
    }
}
