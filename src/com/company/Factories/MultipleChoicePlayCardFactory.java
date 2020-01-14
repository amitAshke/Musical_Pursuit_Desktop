package com.company.Factories;

import java.util.Random;
import com.company.PlayCards.IPlayCard;
import com.company.db.JDBC;

public class MultipleChoicePlayCardFactory implements IPlayCardFactory{

    JDBC jdbc;
    int correctAnswersNum = 8; //Must be more than 1 to make sense;
    int incorrectAnswersNum = 8; //Must be at least as much as "correctAnswersNum" for decent difficulty.


    public MultipleChoicePlayCardFactory(JDBC jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public IPlayCard CreatePlayCard() {

//        HashMap<Integer, List< Song >> answers =  jdbc.getSongsDtl(0, correctAnswersNum, incorrectAnswersNum);

        //Song correctSong = answers.get(0).get(0);
        //List<Song> correctSongs = answers.get(0);
        //List<Song> incorrectSongs = answers.get(1);

        String question;
        String[] correctAnswers = new String[correctAnswersNum];
        String[] incorrectAnswers = new String[incorrectAnswersNum];

//        question = "Pick the songs that " + correctSong.getArtist().getArtistName() + " has released.";

//        for (int i = 0; i < correctAnswersNum; ++i) {
//            correctAnswers[i] = correctSongs.get(i).getTitle();
//        }

//        for (int i = 0; i < incorrectAnswersNum; ++i) {
//            incorrectAnswers[i] = incorrectSongs.get(i).getTitle();
//        }

//        return new MultipleChoicePlayCard(question, correctAnswers, incorrectAnswers);

        return null;
    }
}
