package com.company.gui;

import com.company.PlayCards.AssociationPlayCard;
import com.company.PlayCards.IPlayCard;
import com.company.PlayCards.MultipleChoicePlayCard;
import com.company.PlayCards.SingleAnswerPlayCard;
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
    private StringBuilder answerBuilder;

    public GameWindow(Player player, CommandExecutor executor, Round round) {
        super("Musical Pursuit");
        this.player = player;
        this.executor = executor;
        setLayout(new BorderLayout());
        this.toolbarEngineer = new ToolbarEngineer();
        this.round = round;
        this.roundIterator = round.iterator();
        this.answerBuilder = new StringBuilder();

        //create answer ToolBar using builder
        ToolbarBuilder barBuilder = new ShowAnswerBarBuilder(this.executor, answerBuilder);
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

        this.answerBuilder.delete(0, answerBuilder.toString().length());// reset the answerBuilder
        if (playCard instanceof AssociationPlayCard) {
            this.answerBuilder.append(((AssociationPlayCard) playCard).getAnswer());
            return questionPanel = new AssociationPanel((AssociationPlayCard) playCard);
        } else if (playCard instanceof SingleAnswerPlayCard) {
            this.answerBuilder.append(((SingleAnswerPlayCard) playCard).getAnswer());
            return questionPanel = new SingleAnswerPanel((SingleAnswerPlayCard) playCard);
        } else if (playCard instanceof MultipleChoicePlayCard) {
            for (String s : ((MultipleChoicePlayCard) playCard).getCorrectAnswers()) {
                this.answerBuilder.append(s).append(", ");
            }
            return questionPanel = new MultipleChoicePanel((MultipleChoicePlayCard) playCard);
        }
        return null;
    }
}
