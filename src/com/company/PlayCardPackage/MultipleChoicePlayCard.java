package com.example.dbcourse.Musical_Pursuit.backend.PlayCardPackage;

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


    public String[] getIncorrectAnswers() {
        return incorrectAnswers;
    }


    public String[] getCorrectAnswers() {
        return correctAnswers;
    }
}
