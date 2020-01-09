package com.company.commands;

public class CommandExecutorImpl implements CommandExecutor {
    @Override
    public void runCommand(Command cmd) {
        cmd.execute();
        System.out.println("Command executed");
    }
}
