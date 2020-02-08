package com.company.gui.bar;

import com.company.commands.Command;
import com.company.commands.CommandExecutor;
import com.company.commands.CommandExecutorProxy;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener{

    private JButton btn;
    private Command btnCommand;
    private CommandExecutor commandExecutor;

    public Toolbar(String btnText, CommandExecutor commandExecutor) {
        this.btn = new JButton(btnText);
        this.btn.addActionListener(this::actionPerformed);
        this.commandExecutor = commandExecutor;


        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(btn);
    }

    public void setBtnCommand(Command command) {
        this.btnCommand = command;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton btnClicked = (JButton)e.getSource();

        if (btnClicked == btn) {
           if (btnCommand != null && commandExecutor != null) {
               commandExecutor.runCommand(this.btnCommand);
           }
        }
    }
}
