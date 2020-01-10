package com.company.gui.panels;

import javafx.util.Pair;

import java.util.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OneAssociatePanel extends BasePanel implements ActionListener {

    private ButtonGroup optionsGroup;
    private String[] bandsOption;
    private JLabel associateLabel;
    private JButton band1Btn;
    private JButton band2Btn;
    private Map.Entry<String, Integer> associate;

    public OneAssociatePanel(String[] bandsOption, Map.Entry<String, Integer> associate) {
        super("choose one option");
        this.bandsOption = bandsOption;
        this.associate = associate;
        this.associateLabel = new JLabel(associate.getKey());

        //answers buttons
        band1Btn = new JButton(bandsOption[0]);
        band2Btn = new JButton(bandsOption[1]);
        band1Btn.addActionListener(this);
        band2Btn.addActionListener(this);

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        ///////////////////// First Row //////////////////////////////////
        gc.weightx = 1;
        gc.weighty = 1;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        add(associateLabel, gc);

        ///////////////////// Second Row //////////////////////////////////
        int gridX = 0;
        int gridY = 1;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.gridx = gridX;
        gc.gridy = gridY;
        gc.anchor = GridBagConstraints.CENTER;
        add(band1Btn, gc);

        gridX = 1;
        gc.gridx = gridX;
        add(band2Btn, gc);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnClicked = (JButton)e.getSource();
        if (btnClicked == band1Btn) {
            ((AssociationPanel)getParent()).nextAssociateQuestion(
                    new Pair<>(this.associate.getValue(), 0));
        } else {
            ((AssociationPanel)getParent()).nextAssociateQuestion(
                    new Pair<>(this.associate.getValue(), 1));
        }
    }
}
