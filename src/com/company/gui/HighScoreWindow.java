package com.company.gui;

import com.company.highscore.HighScoresTable;
import com.company.highscore.ScoreInfo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HighScoreWindow extends JFrame {
    final static int WIDTH = 700;
    final static int HEIGHT = 700;
    private HighScoresTable table;
    private HighScorePanel highScorePanel;


    public HighScoreWindow(HighScoresTable table) {
        super("High Score");
        this.table = table;

        List<String> names = new ArrayList<>();
        List<Integer> scores = new ArrayList<>();
        for (ScoreInfo info : table.getHighScores()) {
            names.add(info.getName());
            scores.add(info.getScore());
        }

        this.highScorePanel = new HighScorePanel(names.toArray(new String[names.size()]),
                scores.toArray(new Integer[scores.size()]));

        setLayout(new BorderLayout());
        setSize(WIDTH, HEIGHT);
        add(highScorePanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
