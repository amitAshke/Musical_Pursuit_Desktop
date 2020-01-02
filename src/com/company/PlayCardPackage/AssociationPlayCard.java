package com.company.PlayCardPackage;

import java.util.HashMap;

public class AssociationPlayCard implements IPlayCard{

    private String question = "Choose the band that released the following songs/albums.";
    private String[] options;
    private HashMap<String, Integer> associables;


    public AssociationPlayCard(String[] options, HashMap<String, Integer> associables) {
        this.options = options;
        this.associables = associables;
    }


    public String getQuestion() {
        return question;
    }


    public String[] getOptions() {
        return options;
    }


    public HashMap<String, Integer> getAssociationables() {
        return associables;
    }
}
