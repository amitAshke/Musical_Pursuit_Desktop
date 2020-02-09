package com.company.gui;

import com.company.Factories.MultipleChoicePlayCardFactory;
import com.company.Factories.SingleAnswerPlayCardFactory;
import com.company.PlayCards.IPlayCard;
import com.company.Player;
import com.company.Round;
import com.company.commands.CommandExecutor;
import com.company.commands.CommandExecutorProxy;
import com.company.db.JDBC;
import com.company.gui.bar.*;
import com.company.gui.panels.NewGamePanel;

import javax.swing.*;
import java.awt.*;


public class MainMenu extends JFrame {
    final static int WIDTH = 700;
    final static int HEIGHT = 700;
    final static int SINGLE_ANSWER_PLAYCARDS = 5;
//    final static int MULTIPLE_ANSWER_PLAYCARDS = 2;

    private Toolbar toolbar;
    private NewGamePanel newGamePanel;
    private ToolbarEngineer toolbarEngineer;
    private CommandExecutor executor;
    private Player player;

    public MainMenu(JDBC jdbc) {
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
        //todo: Amit create round and pass round
        newGamePanel = new NewGamePanel(player, getRound(jdbc));
        newGamePanel.setCommandExecutorProxy(this.executor);


        add(toolbar, BorderLayout.NORTH);
        add(newGamePanel, BorderLayout.CENTER);

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);



    }

    public Round getRound(JDBC jdbc){
//        IPlayCard[] playCards = new IPlayCard[SINGLE_ANSWER_PLAYCARDS + MULTIPLE_ANSWER_PLAYCARDS];
        IPlayCard[] playCards = new IPlayCard[SINGLE_ANSWER_PLAYCARDS];
        SingleAnswerPlayCardFactory singleAnswerPlayCardFactory = new SingleAnswerPlayCardFactory(jdbc);
        MultipleChoicePlayCardFactory multipleChoicePlayCardFactory = new MultipleChoicePlayCardFactory(jdbc);

        for(int i = 0; i < SINGLE_ANSWER_PLAYCARDS; ++i) {
            playCards[i] = singleAnswerPlayCardFactory.CreatePlayCard();
        }

//        for(int i = 0; i < MULTIPLE_ANSWER_PLAYCARDS; ++i) {
//            playCards[SINGLE_ANSWER_PLAYCARDS + i] = multipleChoicePlayCardFactory.CreatePlayCard();
//        }

        return new Round(playCards);
    }

}
