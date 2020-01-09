package com.company.gui;

import com.company.Player;
import com.company.commands.CommandExecutor;
import com.company.commands.CommandExecutorProxy;
import com.company.gui.bar.*;
import com.company.gui.panels.NewGamePanel;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    final static int WIDTH = 700;
    final static int HEIGHT = 700;

    private Toolbar toolbar;
    private NewGamePanel newGamePanel;
    private ToolbarEngineer toolbarEngineer;
    private CommandExecutor executor;
    private Player player;

    public MainMenu() {
        super("Musical Pursuit");
        this.toolbarEngineer = new ToolbarEngineer();
        this.executor = new CommandExecutorProxy(); // default executorProxy
        this.player = new Player();
        setLayout(new BorderLayout());

        //create high score ToolBar using builder
        ToolbarBuilder barBuilder = new HighScoreBarBuilder(this.executor);
        toolbarEngineer.setToolBarBuilder(barBuilder);
        toolbarEngineer.constructToolBar();
        toolbar = this.toolbarEngineer.getToolBar();
        newGamePanel = new NewGamePanel(player);


        add(toolbar, BorderLayout.NORTH);
        add(newGamePanel, BorderLayout.CENTER);

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
