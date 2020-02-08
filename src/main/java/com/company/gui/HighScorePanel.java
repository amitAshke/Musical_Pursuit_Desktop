package com.company.gui;

import com.company.gui.panels.BasePanel;

import javax.swing.*;
import java.awt.*;

public class HighScorePanel extends BasePanel {

    private JList namesJList;
    private JList scoresJList;

    public HighScorePanel(String[] names, Integer[] scores) {
        super("High Scores");
        namesJList = new JList(names);
        scoresJList = new JList(scores);
        namesJList.setPreferredSize(new Dimension(1000, 1000));
        scoresJList.setPreferredSize(new Dimension(1000, 1000));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(namesJList, BorderLayout.CENTER);
        add(scoresJList, BorderLayout.CENTER);
    }
}
