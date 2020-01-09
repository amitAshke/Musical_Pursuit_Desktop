package com.company.commands;

public abstract class Command {
    private boolean isAdminCommand;

    public Command(boolean isAdminCommand) {
        this.isAdminCommand = isAdminCommand;
    }

    public boolean isAdminCommand() {
        return isAdminCommand;
    }

    public abstract void execute();
}
