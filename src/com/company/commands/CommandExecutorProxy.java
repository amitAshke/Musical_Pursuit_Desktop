package com.company.commands;

public class CommandExecutorProxy implements CommandExecutor {

    private boolean isAdmin;
    private CommandExecutor executor;
    private String ADMIN_USER = "Admin";
    public CommandExecutorProxy(String username) {
        if (username.equals(ADMIN_USER)) isAdmin = true;
        this.executor = new CommandExecutorImpl(); //insert here CommandExecutorImpl
    }

    public CommandExecutorProxy() {
        //default constructor make regular user, not admin
        this.isAdmin = false;
        this.executor = new CommandExecutorImpl(); //insert here CommandExecutorImpl
    }


    @Override
    public void runCommand(Command cmd){
        if (isAdmin){ //admin can do anything
            this.executor.runCommand(cmd);
        } else {
            //here we need to check if the user is admin, and if the command is for admins only.
            //maybe we can use downcast
            if (!cmd.isAdminCommand())
                this.executor.runCommand(cmd);
        }
    }
}
