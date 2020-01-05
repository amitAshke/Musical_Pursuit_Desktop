package com.company.gui;

import com.company.gui.bar.Toolbar;
import com.company.gui.panels.NewGamePanel;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    final static int WIDTH = 700;
    final static int HEIGHT = 700;

    private Toolbar toolbar;
    private NewGamePanel newGamePanel;

    public MainMenu() {
        super("Musical Pursuit");

        setLayout(new BorderLayout());

        toolbar = new Toolbar();
        newGamePanel = new NewGamePanel();

//        btn.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                textPanel.appendText("Button clicked again\n");
//
//            }
//        });

        add(toolbar, BorderLayout.NORTH);
        add(newGamePanel, BorderLayout.CENTER);

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
