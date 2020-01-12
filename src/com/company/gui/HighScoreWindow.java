package com.company.gui;

import com.company.highscore.HighScoresTable;
import com.company.highscore.ScoreInfo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class HighScoreWindow extends JFrame {
    final static int WIDTH = 700;
    final static int HEIGHT = 700;
    private HighScoresTable table;
    private JList namesJList;
    private JList scoresJList;

    public HighScoreWindow(HighScoresTable table) {
        super("High Score");
        this.table = table;

        List<String> names = new ArrayList<>();
        List<Integer> scores = new ArrayList<>();
        for (ScoreInfo info : table.getHighScores()) {
            names.add(info.getName());
            scores.add(info.getScore());
        }

        namesJList = new JList(names.toArray());
        scoresJList = new JList(scores.toArray());

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(namesJList);
        add(scoresJList);
    }
}
