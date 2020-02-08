package com.company.gui.panels;
import com.company.Player;
import com.company.Round;
import com.company.utils.TestQuestion;
import com.company.commands.CommandExecutor;
import com.company.commands.CommandExecutorProxy;
import com.company.gui.GameWindow;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class NewGamePanel extends BasePanel implements ActionListener {


    private JLabel nameLabel;
    private JTextField nameField;
    private JButton okBtn;
    private Player player;
    private CommandExecutor commandExecutorProxy;

    public NewGamePanel(Player player) {
        super("New Player");
        this.player = player;

        nameLabel = new JLabel("Name: ");
//        occupationLabel = new JLabel("Occupation: ");
        // 10 is the default width in characters
        nameField = new JTextField(10);
        okBtn = new JButton("OK");
        okBtn.addActionListener(this::actionPerformed);

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        ///////////////////// First Row //////////////////////////////////
        /* as in Android, the weight dictates the relative amount of space each element
         * takes in relation with the others.
         */
        gc.weightx = 1;
        gc.weighty = 0.2;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        // the anchor method positions the content "inside" it's container
        gc.anchor = GridBagConstraints.LINE_END;
        add(nameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gc);

        ///////////////////// Second Row //////////////////////////////////
        gc.weightx = 1;
        gc.weighty = 0.2;
        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
//        add(occupationLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
//        add(occupationField, gc);

        ///////////////////// Third Row //////////////////////////////////
        gc.weightx = 1;
        gc.weighty = 8;
        gc.gridx = 1;
        gc.gridy = 2;
        // at the top-left corner of it's container
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okBtn, gc);

    }

    public void setCommandExecutorProxy(CommandExecutor p) {
        this.commandExecutorProxy = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnClicked = (JButton)e.getSource();

        if (btnClicked == okBtn) {
            String name = nameField.getText();
            if (!name.equals("")) {
                this.player.setName(name);
                this.commandExecutorProxy = new CommandExecutorProxy(name);
                System.out.println("new player changed name: " + player.getName());
                //closing the window and opening a game window
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                topFrame.setVisible(false);
                // todo: create a round from question from dataBase.
                new GameWindow(player, commandExecutorProxy, new Round(TestQuestion.getFakeQuestions()));
                topFrame.dispose();
            }

        }
    }
}