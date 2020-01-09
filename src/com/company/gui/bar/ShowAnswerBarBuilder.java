package com.company.gui.bar;

import com.company.commands.CommandExecutor;
import com.company.commands.SimpleCommand;

public class ShowAnswerBarBuilder extends ToolbarBuilder {

    public ShowAnswerBarBuilder(CommandExecutor commandExecutor) {
        super.btnText = "Show Answer";
        super.executor = commandExecutor;
    }


    @Override
    public void buildCommand() {
        // todo: change to showAnswerCommand
        toolbar.setBtnCommand(new SimpleCommand());
    }
}
