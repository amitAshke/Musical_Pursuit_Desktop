package org.musical_pursuit.services.src.FactoryPackage;

import java.util.Random;
import org.musical_pursuit.services.src.PlayCardPackage.IPlayCard;

public class MultipleChoicePlayCardFactory implements IPlayCardFactory{

    @Override
    public IPlayCard CreatePlayCard() {

        /* Calling a function that uses the "context" array and to build a query to send to the local database and
        receive a row. Let's call the object type that contains the data Row and the specific instance trueRows. These
        "trueRows" object will contain the year, the name of the song/album/artist that are asked about.*/

        String question;
        String[] correctAnswers = new String[8];
        String[] incorrectAnswers = new String[8];

//        question = "Pick the songs that " + String.valueOf(row.artist) + " has released.";

//        for (int i = 0; i < correctAnswers.length; ++i) {
//            correctAnswers[i] = trueRows[i].song;
//        }

        /* Calling a function that uses the "context" array to build a query to send to the local database and
        receive 3 rows. Lets call the return object falseRows. These 3 "row" objects will contain the year, the name of
        the song/album/artist that are used as the incorrect answers.*/

//        for (int i = 0; i < incorrectAnswers.length; ++i) {
//            incorrectAnswers[i] = falseRows[i].song;
//        }

//        return new SingleAnswerPlayCard(question, correctAnswer, incorrectAnswers);

        return null;
    }
}
