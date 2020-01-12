package com.company.commands;

import com.company.Player;
import com.company.gui.HighScoreWindow;
import com.company.highscore.HighScoresTable;
import com.company.highscore.ScoreInfo;

import java.io.File;
import java.io.IOException;

public class SaveHighScoreCommand extends Command {
    private int highScore;
    private Player player;

    public SaveHighScoreCommand(Player player) {
        super(false); // not admin command
        this.highScore = player.getScore();
        this.player = player;
    }

    @Override
    public void execute() {
        //load or create the high score table
        HighScoresTable table;
        try {
            table = HighScoresTable.loadFromFile(new File(HighScoresTable.SCORE_TABLE_NAME));
        } catch (IOException e) {
            System.err.println("Failed loading high score table");
            e.printStackTrace(System.err);
            return;
        }
        if (highScore > 0) {
            int rank = table.getRank(highScore);
            if (rank <= HighScoresTable.MAX_SIZE && rank >= 1) {
                //enter the user name and score to the table
                table.add(new ScoreInfo(player.getName(), highScore));

                //save to the table
                try {
                    table.save(new File(HighScoresTable.SCORE_TABLE_NAME));
                } catch (IOException e) {
                    System.err.println("Failed to save the high scores table");
                    e.printStackTrace();
                }
        }

            //create new window of high score
            new HighScoreWindow(table);
        }
    }
}
