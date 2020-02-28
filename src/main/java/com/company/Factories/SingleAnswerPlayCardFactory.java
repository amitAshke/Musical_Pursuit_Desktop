package com.company.Factories;

import com.company.PlayCards.IPlayCard;
import com.company.PlayCards.SingleAnswerPlayCard;
import com.company.db.JDBC;
import com.company.objects.Artist;
import com.company.objects.Song;

import java.util.HashMap;
import java.util.List;
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
        String question;
        String correctAnswer;
        String[] options = new String[totalOptionsNum];

        while(true) {
            boolean restartLoop = false;
            int about = randomizer.nextInt(2); // Decides whether the question is about a song or about an artist.
            int correctPosition = randomizer.nextInt(4);

            // Here the jdbc gets all of the options and specifies the correct answer.
            HashMap<Integer, List<Song>> answers = jdbc.getSongsDtl(1, totalOptionsNum - 1);

            Song correctSong = answers.get(0).get(0);
            Artist correctArtist = correctSong.getArtist();
            List<Song> incorrect = answers.get(1);
            int incorrectIndex = 0;

            // build the question and gets the correct answer based on what the question is about.
            switch (about) {

                // The question is about a song.
                case 0:
                    question = "Which of the following songs was released by " + correctArtist.getArtistName() + " in " + String.valueOf(correctSong.getYear()) + "?";
                    try {
                        correctAnswer = correctSong.getTitle();
                        if (correctAnswer.equals("")) {
                            System.out.println("Empty correct song title");
                            continue;
                        }
                    } catch (NullPointerException e) {
                        continue;
                    }
                    break;

                // The question is about an artist.
                case 1:
                    question = "Which of the following artists has released the song \"" + correctSong.getTitle() + "\" in " + String.valueOf(correctSong.getYear()) + "?";
                    try {
                        correctAnswer = correctArtist.getArtistName();
                        if (correctAnswer.equals("")) {
                            System.out.println("Empty correct song title");
                            continue;
                        }
                    } catch (NullPointerException e) {
                        continue;
                    }
                    break;

                // Only enters if something went wrong with the jdbc's function of getting the options.
                default:
                    correctAnswer = "no answer";
                    question = "no question";
                    System.out.println("Something is wrong with 'about'");
            }

            switch (about) {

                case 0:
                    for (int i = 0; i < totalOptionsNum; ++i) {
                        if (i == correctPosition) {
                            options[i] = correctAnswer;
                            continue;
                        }
                        try {
                            options[i] = incorrect.get(incorrectIndex).getTitle();
                            ++incorrectIndex;
                            if (options[i].equals("")) {
                                restartLoop = true;
                                System.out.println("Empty incorrect song title");
                            }
                        } catch (NullPointerException e) {
                            restartLoop = true;
                            break;
                        }
                    }
                    if (restartLoop) {
                        continue;
                    }
                    break;

                case 1:
                    for (int i = 0; i < totalOptionsNum; ++i) {
                        if (i == correctPosition) {
                            options[i] = correctAnswer;
                            continue;
                        }
                        try {
                            options[i] = incorrect.get(incorrectIndex).getArtist().getArtistName();
                            ++incorrectIndex;
                            if (options[i].equals("")) {
                                restartLoop = true;
                                System.out.println("Empty incorrect song title");
                            }
                        } catch (NullPointerException e) {
                            restartLoop = true;
                            break;
                        }
                    }
                    if (restartLoop) {
                        continue;
                    }
                    break;

                default:
                    System.out.println("Something is wrong with the randomizer.");
                    continue;
            }

            return new SingleAnswerPlayCard(question, correctAnswer, options);
        }
    }
}
