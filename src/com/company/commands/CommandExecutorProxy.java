package com.company.commands;

public class CommandExecutorProxy implements CommandExecutor {

    private boolean isAdmin;
    private CommandExecutor executor;

    public CommandExecutorProxy(String username) {
        String ADMIN_USER = "Admin";
        if (username.equals(ADMIN_USER)) isAdmin = true;
        this.executor = null; //insert here CommandExecutorImpl
    }

    @Override
    public void runCommand(Command cmd){
        if (isAdmin){ //admin can do anything
            this.executor.runCommand(cmd);
        } else {
            //here we need to check if the user is admin, and if the command is for admins only.
            //maybe we can use downcast
            return;
        }
    }
}
