package com.company;

import com.company.commands.CommandExecutor;
import com.company.commands.CommandExecutorImpl;
import com.company.commands.CommandExecutorProxy;
import com.company.gui.GameWindow;
import com.company.gui.MainMenu;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //run the hui on swing thread
        SwingUtilities.invokeLater((new Runnable() {

            @Override
            public void run() {
                MainMenu menu = new MainMenu();
//                GameWindow game = new GameWindow();
            }
        }));

    }
}
