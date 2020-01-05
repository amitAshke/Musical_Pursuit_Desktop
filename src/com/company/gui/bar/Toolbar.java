package com.company.gui.bar;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener{

    private JButton highscoreBtn;

    // todo: think what design pattern I can use so I can add many different btns
    public Toolbar() {
        highscoreBtn = new JButton("High score");

        highscoreBtn.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(highscoreBtn);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        JButton btnClicked = (JButton)e.getSource();

        if (btnClicked == highscoreBtn) {
           System.out.println("high score clicked!");
        }
    }
}
