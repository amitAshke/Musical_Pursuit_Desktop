package org.musical_pursuit.services.src.FactoryPackage;

import java.util.HashMap;
import org.musical_pursuit.services.src.PlayCardPackage.IPlayCard;

public class AssociationPlayCardFactory implements IPlayCardFactory{

    @Override
    public IPlayCard CreatePlayCard() {

        /* Calling a function that build a query to send to the local database and receive 2 artists/bands. Lets call
        the return object "databaseOptions". These 2 "row" objects will only contain the name of artist/band that are
        used as the options. */

        /* Calling a function that build a query with the previously received artist/band to send to the local database
        and receive 30 song/album. Lets call the return object "databaseAssociables". These 30 "row" objects will
        only contain the name of song/album and the name of the artist/band that they belong to. */

        String[] options = new String[2];
        HashMap<String, Integer> associables = new HashMap<>(30);

//        for (int i = 0; i < options.length; ++i) {
//            options[i] = databaseOptions[i].artist/band;
//        }

//        for (int i = 0; i < incorrectAnswers.length; ++i) {
//            if (databaseAssociables[i].artist.equals(options[0]) {
//                    associables.put(databaseAssociables[i].song, 0);
//            } else {
//                    associables.put(databaseAssociables[i].song, 1);
//            }
//        }


//        return new AssociationPlayCard(options, associables);
        return null;
    }
}
