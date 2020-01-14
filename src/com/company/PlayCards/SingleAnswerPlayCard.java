package com.company.PlayCards;

import com.company.gui.panels.BasePanel;
import com.company.gui.panels.SingleAnswerPanel;

public class SingleAnswerPlayCard implements IPlayCard{

    private String question;
    private String answer;
    private String[] options;

    public SingleAnswerPlayCard(String question, String answer, String[] options) {
        this.question = question;
        this.answer = answer;
        this.options = options;
    }

    public String getQuestion() {
        return question;
    }


    public String getAnswer() {
        return answer;
    }

    @Override
    public BasePanel getPanel() {
        return new SingleAnswerPanel(this);
    }


    public String[] getOptions() { return options; }
}
