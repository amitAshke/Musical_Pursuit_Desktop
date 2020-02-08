package com.company.gui.bar;

import com.company.commands.CommandExecutor;
import com.company.commands.SaveHighScoreCommand;
import com.company.commands.SimpleCommand;

public class HighScoreBarBuilder extends ToolbarBuilder {

    public HighScoreBarBuilder(CommandExecutor commandExecutor) {
        super.btnText = "High Score";
        super.executor = commandExecutor;
    }


    @Override
    public void buildCommand() {
        toolbar.setBtnCommand(new SaveHighScoreCommand());
    }
}
