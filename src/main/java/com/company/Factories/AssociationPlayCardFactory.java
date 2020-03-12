package com.company.Factories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.company.PlayCards.AssociationPlayCard;
import com.company.PlayCards.IPlayCard;
import com.company.db.JDBC;
import com.company.objects.Artist;
import com.company.objects.Song;

public class AssociationPlayCardFactory implements IPlayCardFactory{

    JDBC jdbc;
    int associablesNum = 30;


    public AssociationPlayCardFactory(JDBC jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public IPlayCard CreatePlayCard() {

        String[] options = new String[2];
        int i = 0;
        HashMap<Song, Integer> associates = new HashMap<>();
        List<Song> songs = new ArrayList<>();
//        HashMap<Artist, List<Song>> associables = jdbc.getAssociations(associablesNum);

//        for (List<Song> l: associables.values()) {
//            songs.addAll(l);
//        }

//        for(Artist key : associables.keySet()) {
//            options[i] = key.getArtistName();
//        }

//        for (Song song : songs) {
//            if (song.getArtist().getArtistName().equals(options[0])) {
//                associates.put(song, 0);
//            } else {
//                associates.put(song, 1);
//            }
//        }

//        return new AssociationPlayCard(options, associates);
        return null;
    }
}
