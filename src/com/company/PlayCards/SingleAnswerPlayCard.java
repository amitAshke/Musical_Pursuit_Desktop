package com.company.PlayCards;

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


    public String[] getOptions() { return options; }
}
