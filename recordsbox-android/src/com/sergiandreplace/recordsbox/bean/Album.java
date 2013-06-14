package com.sergiandreplace.recordsbox.bean;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Sergi
 * Date: 13/06/13
 * Time: 16:09
 * To change this template use File | Settings | File Templates.
 */
public class Album {


    private String albumTitle;
    private String albumArtist;
    private String coverArtUrl;
    private String albumId;
    private String albumReleaseYear;
    private int albumTrackCount;
    private String albumReviewUrl;
    private int tracks;


    public String getAlbumArtist() {
        return albumArtist;
    }

    public void setAlbumArtist(String albumArtist) {
        this.albumArtist = albumArtist;
    }



    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }



    public String getAlbumReleaseYear() {
        return albumReleaseYear;
    }

    public void setAlbumReleaseYear(String albumReleaseYear) {
        this.albumReleaseYear = albumReleaseYear;
    }

    public String getAlbumReviewUrl() {
        return albumReviewUrl;
    }

    public void setAlbumReviewUrl(String albumReviewUrl) {
        this.albumReviewUrl = albumReviewUrl;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public int getAlbumTrackCount() {
        return albumTrackCount;
    }

    public void setAlbumTrackCount(int albumTrackCount) {
        this.albumTrackCount = albumTrackCount;
    }



    public String getCoverArtUrl() {
        return coverArtUrl;
    }

    public void setCoverArtUrl(String coverArtUrl) {
        this.coverArtUrl = coverArtUrl;
    }



    public int getTracks() {
        return tracks;
    }

    public void setTracks(int tracks) {
        this.tracks = tracks;
    }
}
