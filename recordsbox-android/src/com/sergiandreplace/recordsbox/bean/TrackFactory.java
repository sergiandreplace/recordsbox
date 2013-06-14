package com.sergiandreplace.recordsbox.bean;

import com.gracenote.mmid.MobileSDK.GNDescriptor;
import com.gracenote.mmid.MobileSDK.GNSearchResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Sergi
 * Date: 13/06/13
 * Time: 16:20
 * To change this template use File | Settings | File Templates.
 */
public class TrackFactory {
    public static Track getTrack(GNSearchResponse response) {
        Track t=new Track();
        t.setAlbumArtist(response.getAlbumArtist()) ;
        t.setAlbumartistType(writeMap(response.getArtistType())) ;
        t.setAlbumGenre(writeMap(response.getAlbumGenre())) ;
        t.setAlbumId(response.getAlbumId()) ;
        t.setAlbumReleaseYear(response.getAlbumReleaseYear()) ;
        t.setAlbumReviewUrl(response.getAlbumReviewUrl()) ;
        t.setAlbumTitle(response.getAlbumTitle()) ;
        t.setAlbumTrackCount(response.getAlbumTrackCount()) ;
        t.setArtist(response.getArtist()) ;
        t.setArtistBiographyUrl(response.getArtistBiographyUrl()) ;
        t.setArtistType(writeMap(response.getArtistType()) );
        if (response.getCoverArt()!=null) {
            t.setCoverArtUrl(response.getCoverArt().getUrl()) ;
        }
        t.setEra(writeMap(response.getEra())) ;
        t.setMood(writeMap(response.getMood())) ;
        t.setOrigin(writeMap(response.getOrigin())) ;
        t.setSongPosition(response.getSongPosition()) ;
        t.setTempo(writeMap(response.getTempo())) ;
        t.setTrackGenre(writeMap(response.getTrackGenre())) ;
        t.setTrackId(response.getTrackId()) ;
        t.setTrackNumber(response.getTrackNumber()) ;
        t.setTrackTitle(response.getTrackTitle()) ;


        return t;
    }

    private static Map<String,String> writeMap(GNDescriptor[] source) {
        Map<String,String> target= new HashMap<String, String>();
        for (GNDescriptor descriptor:source) {
            target.put(descriptor.getId(), descriptor.getData());
        }
        return target;
    }
}
