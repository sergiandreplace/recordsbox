package com.sergiandreplace.recordsbox.database;

import android.provider.BaseColumns;

/**
 * Created with IntelliJ IDEA.
 * User: Sergi
 * Date: 31/05/13
 * Time: 02:13
 * To change this template use File | Settings | File Templates.
 */
public final class DatabaseContract {
    public static final String DATABASE_NAME = "recordsbox.db";
    public static final int DATABASE_VERSION = 1;

    public static final class TracksTable {
        public static final String TABLE_NAME = "tracks";
        public static final class Columns implements BaseColumns {
            public static final String ALBUM_TITLE="albumTitle";
            public static final String ALBUM_ARTIST="albumArtist";
            public static final String ARTIST="artist";
            public static final String TRACK_TITLE="trackTitle";
            public static final String COVERT_ART_URL="coverArtUrl";
            public static final String ALBUM_ID="albumId";
            public static final String ALBUM_RELEASE_YEAR="albumReleaseYear";
            public static final String ALBUM_TRACK_COUNT="albumTrackCount";
            public static final String TRACK_NUMBER="trackNumber";
            public static final String GENRE_ID="genreId";
            public static final String GENRE="genre";
            public static final String SONG_POSITION="songPosition";
            public static final String ALBUM_REVIEW_URL="albumReviewUrl";
            public static final String ARTIST_BIOGRAPHY_URL="artistBiographyUrl";
            public static final String ARTIST_IMAGE_URL="artistImageUrl";

        }
    }
}
