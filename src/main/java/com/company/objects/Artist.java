package com.company.objects;

public class Artist {
    private String artistID;
    private String artistName;

    public Artist(String artistID, String artistName) {
        this.artistID = artistID;
        this.artistName = artistName;
    }

    public String getArtistID() {
        return artistID;
    }

    public String getArtistName() {
        return artistName;
    }
}