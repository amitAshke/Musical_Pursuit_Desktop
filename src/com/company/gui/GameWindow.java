package com.company.gui;

import com.company.PlayCardPackage.AssociationPlayCard;
import com.company.PlayCardPackage.IPlayCard;
import com.company.PlayCardPackage.MultipleChoicePlayCard;
import com.company.PlayCardPackage.SingleAnswerPlayCard;
import com.company.Player;
import com.company.Round;
import com.company.commands.CommandExecutor;
import com.company.commands.SaveHighScoreCommand;
import com.company.gui.bar.ShowAnswerBarBuilder;
import com.company.gui.bar.ToolbarBuilder;
import com.company.gui.bar.ToolbarEngineer;
import com.company.gui.panels.AssociationPanel;
import com.company.gui.panels.BasePanel;
import com.company.gui.panels.MultipleChoicePanel;
import com.company.gui.panels.SingleAnswerPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class GameWindow extends JFrame {

    private final static int WIDTH = 700;
    private final static int HEIGHT = 700;

    private Player player;
    private Round round;
    private BasePanel questionPanel;
    private CommandExecutor executor;
    private ToolbarEngineer toolbarEngineer;
    private Iterator<IPlayCard> roundIterator;

    public GameWindow(Player player, CommandExecutor executor, Round round) {
        super("Musical Pursuit");
        this.player = player;
        this.executor = executor;
        setLayout(new BorderLayout());
        this.toolbarEngineer = new ToolbarEngineer();
        this.round = round;
        this.roundIterator = round.iterator();

        //create answer ToolBar using builder
        ToolbarBuilder barBuilder = new ShowAnswerBarBuilder(this.executor);
        toolbarEngineer.setToolBarBuilder(barBuilder);
        toolbarEngineer.constructToolBar();
        add(toolbarEngineer.getToolBar(), BorderLayout.NORTH);

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // add the first question
        if(roundIterator.hasNext()) {
            IPlayCard playCard = roundIterator.next();
            questionPanel = getPanelByPlayCard(playCard);
            if (questionPanel != null) {
                questionPanel.addObserver(player);
                add(questionPanel, BorderLayout.CENTER);
            }

        }
    }

    public void callNextQuestion() {
        remove(this.questionPanel);
        if(roundIterator.hasNext()) {
            IPlayCard playCard = roundIterator.next();
            questionPanel = getPanelByPlayCard(playCard);
            if (questionPanel != null) {
                add(questionPanel, BorderLayout.CENTER);
                questionPanel.addObserver(player);
                //make sure it will draw the new panel
                this.validate();
                this.repaint();
            }
        } else {
            endSequence();
        }

    }

    private void endSequence() {
        System.out.println("end of game, score is " + player.getScore());
        this.dispose();
        new MainMenu();
        executor.runCommand(new SaveHighScoreCommand(player));
    }

    public Iterator<IPlayCard> getRoundIterator() {
        return roundIterator;
    }

    private BasePanel getPanelByPlayCard(IPlayCard playCard) {
        if (playCard instanceof AssociationPlayCard) {
            return questionPanel = new AssociationPanel((AssociationPlayCard) playCard);
        } else if (playCard instanceof SingleAnswerPlayCard) {
            return questionPanel = new SingleAnswerPanel((SingleAnswerPlayCard) playCard);
        } else if (playCard instanceof MultipleChoicePlayCard) {
            return questionPanel = new MultipleChoicePanel((MultipleChoicePlayCard) playCard);
        }
        return null;
    }
}
