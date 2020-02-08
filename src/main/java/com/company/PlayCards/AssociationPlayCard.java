package com.company.PlayCards;

import com.company.gui.panels.AssociationPanel;
import com.company.gui.panels.BasePanel;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

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

    public String getAnswer() {
        StringBuilder ans = new StringBuilder();
        for (Map.Entry<String, Integer> entry : associates.entrySet()) {
           ans.append(entry.getKey()).append(":  ").append(bandsOptions[entry.getValue()]).append("\n");
        }
        return ans.toString();
    }

    @Override
    public BasePanel getPanel() {
        return new AssociationPanel(this);
    }
}
