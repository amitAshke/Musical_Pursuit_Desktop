package com.company.commands;

public class SimpleCommand extends Command {
    public SimpleCommand() {
        super(false); // not admin command
    }

    @Override
    public void execute() {
        System.out.println("I am SimpleCommand!");
    }
}
