package com.company.commands;


import com.company.PlayCardPackage.IPlayCard;

import javax.swing.*;

public class ShowAnswerCommand extends Command {

   private StringBuilder answerBuilder;

    public ShowAnswerCommand(StringBuilder answerBuilder) {
        super(true); // admin command only
        this.answerBuilder = answerBuilder;
    }

    @Override
    public void execute() {
        JOptionPane.showMessageDialog(null, answerBuilder.toString());
    }
}
