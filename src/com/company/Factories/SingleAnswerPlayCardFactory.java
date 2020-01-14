package org.musical_pursuit.services.src.FactoryPackage;

import org.musical_pursuit.services.src.PlayCardPackage.IPlayCard;

import java.util.HashMap;
import java.util.Random;


public class SingleAnswerPlayCardFactory implements IPlayCardFactory{

    @Override
    public IPlayCard CreatePlayCard() {

        Random randomizer = new Random();

        int context =  randomizer.nextInt(2);

        /* Calling a function that uses the "context" array and to build a query to send to the local database and
        receive a row. Let's call the object type that contains the data Row and the specific instance row. This
        "row" object will contain the year, the name of the song/album/artist that are asked about.*/

        String question;
        String correctAnswer;

        switch (context) {
            case 0:
                //question = "Which of the following songs was released by " + String.valueOf(row.artist) + " in " + String.valueOf(row.year) + "?";
                //correctAnswer = row.song;
                break;
            case 1:
                //question = "Which of the following artists has released the song " + String.valueOf(row.song) + " in " + String.valueOf(row.year) + "?";
                //correctAnswer = row.artist;
                break;
            default: System.out.println("Something is wrong with context[0]");
        }

        /* Calling a function that uses the "context" array to build a query to send to the local database and
        receive 3 rows. Lets call the return object falseRows. These 3 "row" objects will contain the year, the name of
        the song/album/artist that are used as the incorrect answers.*/

        String[] incorrectAnswers = new String[3];
        switch (context) {
            case 0:
//                correctAnswer = row.song;
//                for (int i = 0; i < incorrectAnswers.length; ++i) {
//                    incorrectAnswers[i] = falseRows[i].song;
//                }
                break;
            case 1:
//                correctAnswer = row.album;
//                for (int i = 0; i < incorrectAnswers.length; ++i) {
//                    incorrectAnswers[i] = falseRows[i].artist;
//                }
                break;
            default: System.out.println("Something is wrong with context[1]");
        }

//        return new SingleAnswerPlayCard(question, correctAnswer, incorrectAnswers);
        return null;
    }
}
