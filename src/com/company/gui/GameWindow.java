package com.company.gui;

import com.company.PlayCardPackage.SingleAnswerPlayCard;
import com.company.Player;
import com.company.Round;
import com.company.gui.panels.SingleAnswerPanel;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    final static int WIDTH = 700;
    final static int HEIGHT = 700;

    private Player player;
    private Round round;
    private SingleAnswerPanel singleAnswerPanel;

    public GameWindow() {
        super("Musical Pursuit");
        setLayout(new BorderLayout());

        String ans[] = {"one", "two", "three", "five"};
        SingleAnswerPlayCard question = new SingleAnswerPlayCard("what num is this: 5", "five", ans);


        singleAnswerPanel = new SingleAnswerPanel(question);
        add(singleAnswerPanel, BorderLayout.CENTER);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
