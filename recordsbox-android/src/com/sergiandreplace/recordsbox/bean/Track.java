package com.sergiandreplace.recordsbox.bean;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Sergi
 * Date: 13/06/13
 * Time: 16:09
 * To change this template use File | Settings | File Templates.
 */
public class Track {


    private String albumTitle;
    private String albumArtist;
    private String artist;
    private String trackTitle;
    private String trackId;
    private String coverArtUrl;
    private String albumId;
    private String albumReleaseYear;
    private int albumTrackCount;
    private int trackNumber;
    private String genreId;
    private String genre;
    private String songPosition;
    private String albumReviewUrl;
    private String artistBiographyUrl;
    private String artistImageUrl;
    private Map<String, String> trackGenre;
    private Map<String, String> albumGenre;
    private Map<String, String> mood;
    private Map<String, String> tempo;
    private Map<String, String> origin;
    private Map<String, String> era;
    private Map<String, String> artistType;
    private Map<String, String> albumartistType;

    public String getAlbumArtist() {
        return albumArtist;
    }

    public void setAlbumArtist(String albumArtist) {
        this.albumArtist = albumArtist;
    }

    public Map<String, String> getAlbumartistType() {
        return albumartistType;
    }

    public void setAlbumartistType(Map<String, String> albumartistType) {
        this.albumartistType = albumartistType;
    }


    public Map<String, String> getAlbumGenre() {
        return albumGenre;
    }

    public void setAlbumGenre(Map<String, String> albumGenre) {
        this.albumGenre = albumGenre;
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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtistBiographyUrl() {
        return artistBiographyUrl;
    }

    public void setArtistBiographyUrl(String artistBiographyUrl) {
        this.artistBiographyUrl = artistBiographyUrl;
    }

    public String getArtistImageUrl() {
        return artistImageUrl;
    }

    public void setArtistImageUrl(String artistImageUrl) {
        this.artistImageUrl = artistImageUrl;
    }

    public Map<String, String> getArtistType() {
        return artistType;
    }

    public void setArtistType(Map<String, String> artistType) {
        this.artistType = artistType;
    }

    public String getCoverArtUrl() {
        return coverArtUrl;
    }

    public void setCoverArtUrl(String coverArtUrl) {
        this.coverArtUrl = coverArtUrl;
    }

    public Map<String, String> getEra() {
        return era;
    }

    public void setEra(Map<String, String> era) {
        this.era = era;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenreId() {
        return genreId;
    }

    public void setGenreId(String genreId) {
        this.genreId = genreId;
    }

    public Map<String, String> getMood() {
        return mood;
    }

    public void setMood(Map<String, String> mood) {
        this.mood = mood;
    }

    public Map<String, String> getOrigin() {
        return origin;
    }

    public void setOrigin(Map<String, String> origin) {
        this.origin = origin;
    }

    public String getSongPosition() {
        return songPosition;
    }

    public void setSongPosition(String songPosition) {
        this.songPosition = songPosition;
    }

    public Map<String, String> getTempo() {
        return tempo;
    }

    public void setTempo(Map<String, String> tempo) {
        this.tempo = tempo;
    }

    public Map<String, String> getTrackGenre() {
        return trackGenre;
    }

    public void setTrackGenre(Map<String, String> trackGenre) {
        this.trackGenre = trackGenre;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public String getTrackTitle() {
        return trackTitle;
    }

    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }
}
