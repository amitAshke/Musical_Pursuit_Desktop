package com.company.commands;

public abstract class Command {
    private boolean isAdminCommand;

    public Command(boolean isAdminCommand) {
        /**
         * @param isAdminCommand: true if command should be for admins only, else false
         */
        this.isAdminCommand = isAdminCommand;
    }

    public boolean isAdminCommand() {
        return isAdminCommand;
    }

    public abstract void execute();
}
