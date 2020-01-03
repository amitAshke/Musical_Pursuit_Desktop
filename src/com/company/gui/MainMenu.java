package com.company.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    final static int WIDTH = 700;
    final static int HEIGHT = 700;

    private static final long serialVersionUID = 1L;
    private Toolbar toolbar;
    private FormPanel formPanel;

    public MainMenu() {
        super("Size");

        setLayout(new BorderLayout());

        toolbar = new Toolbar();
        formPanel = new FormPanel();

        toolbar.setStringListener(new StringListener() {

            @Override
            public void textEmitted(String text) {
                // override the method set up in the custom interface
                System.out.println(text);
            }
        });

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
        add(formPanel, BorderLayout.CENTER);

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
