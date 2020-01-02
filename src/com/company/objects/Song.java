package com.example.dbcourse.Musical_Pursuit.backend.objects;

class Album {
    private String albumID;
    private String albumName;

    public Album(String albumID, String albumName) {
        this.albumID = albumID;
        this.albumName = albumName;
    }

    public String getAlbumID() {
        return albumID;
    }

    public String getAlbumName() {
        return albumName;
    }
}

class Artist {
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

public class Song {
    private String songID;
    private String title;
    private int year;
    private Artist artist;
    private Album album;

    public Song(String songID, String title, int year, Artist artist, Album album) {
        this.songID = songID;
        this.title = title;
        this.year = year;
        this.artist = artist;
        this.album = album;
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

    public Album getAlbum() {
        return album;
    }

}
