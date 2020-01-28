package com.company.Factories;

import java.util.HashMap;
import java.util.List;
import com.company.PlayCards.IPlayCard;
import com.company.PlayCards.MultipleChoicePlayCard;
import com.company.db.JDBC;
import com.company.objects.Song;

public class MultipleChoicePlayCardFactory implements IPlayCardFactory{

    JDBC jdbc;
    int correctAnswersNum = 8; //Must be more than 1 to make sense;
    int incorrectAnswersNum = 8; //Must be at least as much as "correctAnswersNum" for decent difficulty.


    public MultipleChoicePlayCardFactory(JDBC jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public IPlayCard CreatePlayCard() {

        String[] options = new String[correctAnswersNum + incorrectAnswersNum];

        while(true) {

            boolean restartLoop = false;

            HashMap<Integer, List<Song>> answers = jdbc.getSongsDtl(correctAnswersNum, incorrectAnswersNum);

            Song correctSong = answers.get(0).get(0);
            List<Song> correctSongs = answers.get(0);
            List<Song> incorrectSongs = answers.get(1);

            String question;
            String[] correctAnswers = new String[correctAnswersNum];
            String[] incorrectAnswers = new String[incorrectAnswersNum];

            question = "Pick the songs that " + correctSong.getArtist().getArtistName() + " has released.";

            for (int i = 0; i < correctAnswersNum; ++i) {
                try {
                    correctAnswers[i] = correctSongs.get(i).getTitle();
                } catch (NullPointerException e) {
                    restartLoop = true;
                    System.out.println("null correct song title");
                    break;
                }
            }

            if (restartLoop) {
                continue;
            }

            for (int i = 0; i < incorrectAnswersNum; ++i) {
                try {
                    incorrectAnswers[i] = incorrectSongs.get(i).getTitle();
                } catch (NullPointerException e) {
                    restartLoop = true;
                    System.out.println("null incorrect song title");
                    break;
                }
            }

            if (restartLoop) {
                continue;
            }

            return new MultipleChoicePlayCard(question, correctAnswers, incorrectAnswers);
        }
    }
}
