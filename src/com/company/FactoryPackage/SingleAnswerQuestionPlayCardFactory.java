package com.company.FactoryPackage;

import com.company.PlayCardPackage.IPlayCard;

import java.util.HashMap;
import java.util.Random;


public class SingleAnswerQuestionPlayCardFactory implements IPlayCardFactory{

    private HashMap<int[], String> contextHash = new HashMap<>();
    private Random randomizer = new Random();

    public SingleAnswerQuestionPlayCardFactory() {

        contextHash.put(new int[] {0,1}, " was released by the artist/band _______________.");
        contextHash.put(new int[] {0,2}, " was released as part of the album _______________.");
        contextHash.put(new int[] {1,0}, " was released by the artist/band _______________.");
        contextHash.put(new int[] {1,2}, " was released, containing the song _______________.");
        contextHash.put(new int[] {2,0}, " has released the song _______________.");
        contextHash.put(new int[] {2,1}, " has released the album _______________.");

    }

    @Override
    public IPlayCard CreatePlayCard() {

        int[] context = new int[2];

        context[0] =  randomizer.nextInt(3);

        do {
            context[1] = randomizer.nextInt(3);
        }
        while(context[0] == context[1]);

        /* Calling a function that uses the "context" array and to build a query to send to the local database and
        receive a row. Let's call the object type that contains the data Row and the specific instance row. This
        "row" object will contain the year, the name of the song/album/artist that are asked about.*/

        String question;
        switch (context[0]) {
            case 0:
                //question = "in " + String.valueOf(row.year) + ", the song" + row.song + contextHash.get(context);
                break;
            case 1:
                //question = "in " + String.valueOf(row.year) + ", the album" + row.album + contextHash.get(context);
                break;
            case 2:
                //question = "in " + String.valueOf(row.year) + ", the artist/band" + row.artist/band + contextHash.get
                // (context);
                break;
            default: System.out.println("Something is wrong with context[0]");
        }

        /* Calling a function that uses the "context" array to build a query to send to the local database and
        receive 3 rows. Lets call the return object falseRows. These 3 "row" objects will contain the year, the name of
        the song/album/artist that are used as the incorrect answers.*/

        String correctAnswer;
        String[] incorrectAnswers = new String[3];
        switch (context[1]) {
            case 0:
//                correctAnswer = row.song;
//                for (int i = 0; i < incorrectAnswers.length; ++i) {
//                    incorrectAnswers[i] = falseRows[i].song;
//                }
                break;
            case 1:
//                correctAnswer = row.album;
//                for (int i = 0; i < incorrectAnswers.length; ++i) {
//                    incorrectAnswers[i] = falseRows[i].album;
//                }
                break;
            case 2:
//                correctAnswer = row.artist/band;
//                for (int i = 0; i < incorrectAnswers.length; ++i) {
//                    incorrectAnswers[i] = falseRows[i].artist/band;
//                }
                break;
            default: System.out.println("Something is wrong with context[1]");
        }

//        return new SingleAnswerPlayCard(question, correctAnswer, incorrectAnswers);
        return null;
    }
}
