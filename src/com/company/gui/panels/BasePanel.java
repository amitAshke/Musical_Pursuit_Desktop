package com.company.gui.panels;

import com.company.observbale.Observable;
import com.company.observbale.Observer;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BasePanel extends JPanel implements Observable {

    private List<Observer> observers;

    public BasePanel(String panelName) {
        this.observers = new ArrayList<>();
        //each component has a default size
        Dimension dim = getPreferredSize();
        // set the size of the formPanel
        dim.width = 250;
        setPreferredSize(dim);
        /* each graphic element can have a border, with setBorder. In this case, the
         * static method compoundBorder takes two border objects as parameters
         */
        Border innerBorder = BorderFactory.createTitledBorder(panelName);
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
    }

    @Override
    public void addObserver(Observer observer) {
        if (observer != null)
            if (!observers.contains(observer))
                observers.add(observer);

    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void addScore(int score) {
        for (Observer observer:
                observers) {
            observer.update(this, score);
        }
    }
}
