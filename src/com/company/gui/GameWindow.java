package com.company.gui;

import com.company.PlayCardPackage.MultipleChoicePlayCard;
import com.company.PlayCardPackage.SingleAnswerPlayCard;
import com.company.Player;
import com.company.Round;
import com.company.gui.bar.Toolbar;
import com.company.gui.panels.MultipleChoicePanel;
import com.company.gui.panels.SingleAnswerPanel;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    final static int WIDTH = 700;
    final static int HEIGHT = 700;

    private Player player;
    private Round round;
    private SingleAnswerPanel singleAnswerPanel;
    private Toolbar toolbar;

    public GameWindow() {
        super("Musical Pursuit");
        setLayout(new BorderLayout());

        String ans[] = {"one", "two", "three", "five"};
        String incorectAns[] = {"six", "seven", "eight"};
        SingleAnswerPlayCard question = new SingleAnswerPlayCard("what num is this: 5", "five", ans);

        toolbar = new Toolbar();
        add(toolbar, BorderLayout.NORTH);
        MultipleChoicePlayCard multipleChoice = new MultipleChoicePlayCard("what num is this: 5", incorectAns, ans);
        MultipleChoicePanel multipleChoicePanel = new MultipleChoicePanel(multipleChoice);
        add(multipleChoicePanel, BorderLayout.CENTER);

//        singleAnswerPanel = new SingleAnswerPanel(question);
//        add(singleAnswerPanel, BorderLayout.CENTER);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}