package com.intersog.androidcourse.rimma.intersoghomework13;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.provider.BaseColumns;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class MainActivity extends ActionBarActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    private ListView listViewPhotos;
    public static final int LOADER_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewPhotos = (ListView) findViewById(R.id.list_photos);
        getLoaderManager().initLoader(LOADER_ID, null, this);
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                new String[] {BaseColumns._ID,MediaStore.Images.Media.DATA},
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        listViewPhotos.setAdapter(new SimpleCursorAdapter(this,
                R.layout.photo_item,
                cursor,
                new String[] {MediaStore.Images.Media.DATA},
                new int[] {R.id.image_photo_list_view},
                0));
    }

    @Override
    public void onLoaderReset(Loader loader) {

    }
}
