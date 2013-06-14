package com.sergiandreplace.recordsbox.content;

import android.net.Uri;
import android.provider.BaseColumns;
import com.sergiandreplace.recordsbox.database.DatabaseContract;

/**
 * Created with IntelliJ IDEA.
 * User: Sergi
 * Date: 31/05/13
 * Time: 02:26
 * To change this template use File | Settings | File Templates.
 */
public final class ContentContract {
    public static final String AUTHORITY = "com.sergiandreplace.recordsbox";
    public static final Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);

    public static final class TracksCursor {
        public static final String PATH_DIR = "track";
        public static final String PATH_ITEM = "track/#";
        public static final Uri CONTENT_URI_DIR = Uri.withAppendedPath(AUTHORITY_URI, PATH_DIR);
        public static final Uri CONTENT_URI_ITEM = Uri.withAppendedPath(AUTHORITY_URI, PATH_ITEM);
        public static final String CONTENT_TYPE_DIR = "vnd.android.cursor.dir/vnd.com.recordsbox.track";
        public static final String CONTENT_TYPE_ITEM = "vnd.android.cursor.item/vnd.com.recordsbox.track";

        public static final class Columns implements BaseColumns {
            public static final String ALBUM_TITLE = DatabaseContract.TracksTable.Columns.ALBUM_TITLE;
            public static final String ALBUM_ARTIST = DatabaseContract.TracksTable.Columns.ALBUM_ARTIST;
            public static final String ARTIST = DatabaseContract.TracksTable.Columns.ARTIST;
            public static final String TRACK_TITLE = DatabaseContract.TracksTable.Columns.TRACK_TITLE;
            public static final String COVERT_ART_URL = DatabaseContract.TracksTable.Columns.COVERT_ART_URL;
            public static final String ALBUM_ID = DatabaseContract.TracksTable.Columns.ALBUM_ID;
            public static final String ALBUM_RELEASE_YEAR = DatabaseContract.TracksTable.Columns.ALBUM_RELEASE_YEAR;
            public static final String ALBUM_TRACK_COUNT = DatabaseContract.TracksTable.Columns.ALBUM_TRACK_COUNT;
            public static final String TRACK_NUMBER = DatabaseContract.TracksTable.Columns.TRACK_NUMBER;
            public static final String GENRE_ID = DatabaseContract.TracksTable.Columns.GENRE_ID;
            public static final String GENRE = DatabaseContract.TracksTable.Columns.GENRE;
            public static final String SONG_POSITION = DatabaseContract.TracksTable.Columns.SONG_POSITION;
            public static final String ALBUM_REVIEW_URL = DatabaseContract.TracksTable.Columns.ALBUM_REVIEW_URL;
            public static final String ARTIST_BIOGRAPHY_URL = DatabaseContract.TracksTable.Columns.ARTIST_BIOGRAPHY_URL;
            public static final String ARTIST_IMAGE_URL = DatabaseContract.TracksTable.Columns.ARTIST_IMAGE_URL;

        }
    }

    public static final class AlbumsCursor {
        public static final String PATH_DIR = "album";
        public static final String PATH_ITEM = "album/#";
        public static final Uri CONTENT_URI_DIR = Uri.withAppendedPath(AUTHORITY_URI, PATH_DIR);
        public static final Uri CONTENT_URI_ITEM = Uri.withAppendedPath(AUTHORITY_URI, PATH_ITEM);
        public static final String CONTENT_TYPE_DIR = "vnd.android.cursor.dir/vnd.com.recordsbox.album";
        public static final String CONTENT_TYPE_ITEM = "vnd.android.cursor.item/vnd.com.recordsbox.album";

        public static final class Columns implements BaseColumns {
            public static final String ALBUM_TITLE = DatabaseContract.TracksTable.Columns.ALBUM_TITLE;
            public static final String ALBUM_ARTIST = DatabaseContract.TracksTable.Columns.ALBUM_ARTIST;
            public static final String COVERT_ART_URL = DatabaseContract.TracksTable.Columns.COVERT_ART_URL;
            public static final String ALBUM_ID = DatabaseContract.TracksTable.Columns.ALBUM_ID;
            public static final String ALBUM_RELEASE_YEAR = DatabaseContract.TracksTable.Columns.ALBUM_RELEASE_YEAR;
            public static final String ALBUM_TRACK_COUNT = DatabaseContract.TracksTable.Columns.ALBUM_TRACK_COUNT;
            public static final String TRACK_NUMBER = DatabaseContract.TracksTable.Columns.TRACK_NUMBER;
            public static final String ALBUM_REVIEW_URL = DatabaseContract.TracksTable.Columns.ALBUM_REVIEW_URL;
            ;
        }
    }
}
