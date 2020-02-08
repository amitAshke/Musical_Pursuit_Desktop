package com.company.PlayCards;

import com.company.gui.panels.BasePanel;
import com.company.gui.panels.MultipleChoicePanel;

public class MultipleChoicePlayCard implements IPlayCard{

    private String question;
    private String[] incorrectAnswers;
    private String[] correctAnswers;


    public MultipleChoicePlayCard(String question, String[] incorrectAnswers, String[] correctAnswers) {
        this.question = question;
        this.incorrectAnswers = incorrectAnswers;
        this.correctAnswers = correctAnswers;
    }


    public String getQuestion() {
        return question;
    }

    @Override
    public String getAnswer() {
       return String.join(", ", correctAnswers);
    }

    @Override
    public BasePanel getPanel() {
       return new MultipleChoicePanel(this);
    }


    public String[] getIncorrectAnswers() {
        return incorrectAnswers;
    }


    public String[] getCorrectAnswers() {
        return correctAnswers;
    }
}
