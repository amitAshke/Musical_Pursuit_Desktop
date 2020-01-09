package com.company.gui.bar;

public class ToolbarEngineer {
    private ToolbarBuilder toolBarBuilder;

    public void setToolBarBuilder(ToolbarBuilder barBuilder) {
        this.toolBarBuilder = barBuilder;
    }

    public Toolbar getToolBar() {
        return toolBarBuilder.getToolBar();
    }

    public void constructToolBar() {
        toolBarBuilder.createNewToolBar();
        toolBarBuilder.buildCommand();
    }
}
