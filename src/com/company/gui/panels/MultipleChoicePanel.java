package com.company.gui.panels;

import com.company.PlayCards.MultipleChoicePlayCard;
import com.company.gui.GameWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultipleChoicePanel extends BasePanel {
    private ArrayList<JCheckBox> optionsCheckBoxList;
    private MultipleChoicePlayCard singleAnswerPlayCard;

    public MultipleChoicePanel(MultipleChoicePlayCard singleAnswerPlayCard) {
        super("Multiple Choice Play card");
        this.singleAnswerPlayCard = singleAnswerPlayCard;
        this.optionsCheckBoxList = new ArrayList<>();

        JLabel questionLabel = new JLabel(singleAnswerPlayCard.getQuestion());
        // add the correct and incorrect answers
        for (String option : singleAnswerPlayCard.getCorrectAnswers()) {
            JCheckBox btn = new JCheckBox(option);
            optionsCheckBoxList.add(btn);
        }
        for (String option : singleAnswerPlayCard.getIncorrectAnswers()) {
            JCheckBox btn = new JCheckBox(option);
            optionsCheckBoxList.add(btn);
        }

        //shuffle the order in the list
        Collections.shuffle(optionsCheckBoxList);
        JButton submitBtn = new JButton("Submit");

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        ///////////////////// First Row //////////////////////////////////
        gc.weightx = 1;
        gc.weighty = 1;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        add(questionLabel, gc);

        ///////////////////// Second Row and more//////////////////////////////////
        int gridX = 0;
        int gridY = 1;

        int count = 0;
        for (JCheckBox rBtn : optionsCheckBoxList) {
            gc.weightx = 1;
            gc.weighty = 1;
            gc.gridx = gridX;
            gc.gridy = gridY;
            gc.anchor = GridBagConstraints.CENTER;
            add(rBtn, gc);
            if (count % 2 == 0){
                gridX++; // move one to the column on the right
            } else {
                gridY++; // get down one row
                gridX = 0; // return the x position (column) to left side
            }
            count++;
        }

        ///////////////////// Last Row //////////////////////////////////
        gc.weightx = 1;
        gc.weighty = 1;
        gc.gridx = 0;
        gc.gridy = gridY;
        gc.anchor = GridBagConstraints.LINE_END;
        add(submitBtn, gc);

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> userAnswersList = new ArrayList<>();
                for(JCheckBox cb : optionsCheckBoxList) {
                    if (cb.isSelected()) {
                        userAnswersList.add(cb.getText());
                    }
                }

                if (userAnswersList.size() != 0) {
                    int score = 0;
                    for (String tryAnswer : userAnswersList) {
                        boolean isCorrect = false;
                        for (String realAnswer : singleAnswerPlayCard.getCorrectAnswers()) {
                            if (realAnswer.equals(tryAnswer)) {
                                isCorrect = true;
                                break;
                            }
                        }
                        if (isCorrect)
                            score += 1;
                        else
                            score -= 1;
                    }
                    if (score > 0) {
                        addScore(score);
                    }

                    ((GameWindow)javax.swing.FocusManager.getCurrentManager().getActiveWindow()).callNextQuestion();
                } else {
                    //user did'nt selected anything
                    System.out.println("no answer");
                }


            }
        });
    }
}
