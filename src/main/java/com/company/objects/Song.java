package com.company.objects;

public class Song {
    private String songID;
    private String title;
    private int year;
    private Artist artist;

    public Song(String songID, String title, int year, Artist artist) {
        this.songID = songID;
        this.title = title;
        this.year = year;
        this.artist = artist;
    }

    public String getSongID() {
        return songID;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public Artist getArtist() {
        return artist;
    }

}
