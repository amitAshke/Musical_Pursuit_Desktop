package com.company.Factories;

import com.company.PlayCards.IPlayCard;
import com.company.db.JDBC;

import java.util.HashMap;
import java.util.Random;


public class SingleAnswerPlayCardFactory implements IPlayCardFactory{

    JDBC jdbc;
    int totalOptionsNum = 4;


    public SingleAnswerPlayCardFactory(JDBC jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public IPlayCard CreatePlayCard() {

        Random randomizer = new Random();

        int about =  randomizer.nextInt(2);

//        HashMap<Integer, List< Song >> answers =  jdbc.getSongsDtl(0, 1, totalOptionsNum - 1);

        String question;
//        String correctAnswer;
        String[] options = new String[totalOptionsNum];

        //Song correctSong = answers.get(0).get(0);
        //Artist correctArtist = correctSong.getArtist();
        //List<Song> incorrectSongs = answers.get(1);

        switch (about) {
            case 0:
                //question = "Which of the following songs was released by " + correctArtist.getArtistName() + " in " + String.valueOf(correctSong.getYear()) + "?";
                //correctAnswer = correctSong.getTitle();
                break;
            case 1:
                //question = "Which of the following artists has released the song " + correctSong.getTitle() + " in " + String.valueOf(correctSong.getYear()) + "?";
                //correctAnswer = correctArtist.getArtistName();
                break;
            default: System.out.println("Something is wrong with 'about'");
        }

//        options[totalOptionsNum - 1] = correctAnswer;

//        List<Song> incorrect = answers.get(1);

        switch (about) {
            case 0:
//                for (int i = 0; i < totalOptionsNum - 1; ++i) {
//                    options[i] = incorrect.get(i).getTitle();
//                }
                break;
            case 1:
//                for (int i = 0; i < totalOptionsNum - 1; ++i) {
//                    options[i] = incorrect.get(i).getArtist().getArtistName();
//                }
                break;
            default: System.out.println("Something is wrong with 'about'");
        }

//        return new SingleAnswerPlayCard(question, correctAnswer, incorrectAnswers);
        return null;
    }
}
