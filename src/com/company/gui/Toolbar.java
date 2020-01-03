package com.company.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener{

    private static final long serialVersionUID = 1L;
    private JButton highscoreBtn;


    private StringListener textListener;

    public Toolbar() {
        highscoreBtn = new JButton("High score");

        highscoreBtn.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(highscoreBtn);
    }

    public void setStringListener(StringListener listener) {
        this.textListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton btnClicked = (JButton)e.getSource();

        if (btnClicked == highscoreBtn) {
            if (textListener != null) {
                textListener.textEmitted("Hello\n");
            }
        }
    }
}
