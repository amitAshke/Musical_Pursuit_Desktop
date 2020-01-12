package com.company.gui.bar;

import com.company.commands.CommandExecutor;
import com.company.commands.ShowAnswerCommand;
import com.company.commands.SimpleCommand;

public class ShowAnswerBarBuilder extends ToolbarBuilder {

    private StringBuilder answerBuilder;

    public ShowAnswerBarBuilder(CommandExecutor commandExecutor, StringBuilder answerBuilder) {
        super.btnText = "Show Answer";
        super.executor = commandExecutor;
        this.answerBuilder = answerBuilder;
    }

    @Override
    public void buildCommand() {
        toolbar.setBtnCommand(new ShowAnswerCommand(answerBuilder));
    }
}
