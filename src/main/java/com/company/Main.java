package com.company;

import com.company.db.JDBC;
import com.company.gui.MainMenu;
import com.company.utils.ChangeUIFont;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JDBC jdbc = new JDBC();
        //run the gui on swing thread
        SwingUtilities.invokeLater((new Runnable() {

            @Override
            public void run() {
                ChangeUIFont.setUIFont (new javax.swing.plaf.FontUIResource("Ariel", Font.ITALIC,16));
                MainMenu menu = new MainMenu(jdbc);
            }
        }));

    }

}
