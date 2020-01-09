package com.company.gui.bar;

import com.company.commands.CommandExecutor;

public abstract class ToolbarBuilder {
    protected Toolbar toolbar;
    protected String btnText;
    protected CommandExecutor executor;

    public Toolbar getToolBar() {
        return toolbar;
    }

    public void createNewToolBar() {
        toolbar = new Toolbar(btnText, executor);
    }
    // what can be built, need to correspond to setMethod in ToolBar
    public abstract void buildCommand();
}
