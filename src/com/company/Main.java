package com.company;

import com.company.gui.MainMenu;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        //run the hui on swing thread
        SwingUtilities.invokeLater((new Runnable() {

            @Override
            public void run() {
                MainMenu menu = new MainMenu();
            }
        }));

    }
}
