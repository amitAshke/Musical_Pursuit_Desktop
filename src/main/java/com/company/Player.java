package com.company;


import com.company.observbale.Observable;
import com.company.observbale.Observer;

public class Player implements Observer {
    private String name;
    private int score;

    public Player() {
        this.name = "New Player";
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void update(Observable o, Object arg) {
        score += (int)arg;
    }
}
