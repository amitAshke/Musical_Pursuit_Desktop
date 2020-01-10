package com.company.PlayCardPackage;

import java.util.HashMap;

public class AssociationPlayCard implements IPlayCard{

    private static String question = "Choose the band that released the following songs.";
    private String[] bandsOptions; // band option
    private HashMap<String, Integer> associates; // integer is always 0, 1 to much band in in options


    public AssociationPlayCard(String[] bandOptions, HashMap<String, Integer> associates) {
        this.bandsOptions = bandOptions;
        this.associates = associates;
    }


    public String getQuestion() {
        return question;
    }


    public String[] getBandsOptions() {
        return bandsOptions;
    }


    public HashMap<String, Integer> getAssociations() {
        return associates;
    }
}
