package com.example.dbcourse.Musical_Pursuit.backend.FactoryPackage;

import java.util.Random;
import com.example.dbcourse.Musical_Pursuit.backend.PlayCardPackage.IPlayCard;

public class MultipleChoicePlayCardQuestionFactory implements IPlayCardFactory{

    private Random randomizer = new Random();

    @Override
    public IPlayCard CreatePlayCard() {

        int context = randomizer.nextInt(2);

        /* Calling a function that uses the "context" to build a query to send to the local database and
        receive 8 rows. Lets call the return object trueRows. These 3 "row" objects will contain the year, the name of
        the song/album/artist that are used as the correct answers.*/

        String question;
        switch (context) {
            case 0:
                //question = "Pick the songs that are in the album " + row.album + ".";
                break;
            case 1:
                //question = "Pick the songs that where released by the artist/band " + row.artist/band + ".";
                break;
            default: System.out.println("Something is wrong with context[0]");
        }

        /* Calling a function that uses the "context" to build a query to send to the local database and
        receive 8 rows. Lets call the return object falseRows. These 3 "row" objects will contain the year, the name of
        the song/album/artist that are used as the incorrect answers.*/

        String[] correctAnswers = new String[8];
        String[] incorrectAnswers = new String[8];

//        for (int i = 0; i < correctAnswers.length; ++i) {
//            correctAnswers[i] = trueRows[i].song;
//        }

//        for (int i = 0; i < incorrectAnswers.length; ++i) {
//            incorrectAnswers[i] = falseRows[i].song;
//        }


//        return new SingleAnswerPlayCard(question, correctAnswers, incorrectAnswers);
        return null;
    }
}
