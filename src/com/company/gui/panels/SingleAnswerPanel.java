package com.company.gui.panels;

import com.company.PlayCardPackage.SingleAnswerPlayCard;
import com.company.Player;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

public class SingleAnswerPanel extends JPanel {
    private JLabel questionLabel;
    private JButton submitBtn;
    private ArrayList<JRadioButton> optionsButtonsList;
    private ButtonGroup optionsGroup;
    private boolean isAnswerCorrect;
    private SingleAnswerPlayCard singleAnswerPlayCard;


    public SingleAnswerPanel(SingleAnswerPlayCard singleAnswerPlayCard) {
        this.singleAnswerPlayCard = singleAnswerPlayCard;
        this.optionsButtonsList = new ArrayList<>();
        //each component has a default size
        Dimension dim = getPreferredSize();

        // set the size of the formPanel
        dim.width = 250;
        setPreferredSize(dim);

        questionLabel = new JLabel(singleAnswerPlayCard.getQuestion());
        optionsGroup = new ButtonGroup();
        for (String option : singleAnswerPlayCard.getOptions()) {
            JRadioButton btn = new JRadioButton(option);
            optionsButtonsList.add(btn);
            optionsGroup.add(btn);
        }
        submitBtn = new JButton("Submit");

        /* each graphic element can have a border, with setBorder. In this case, the
         * static method compoundBorder takes two border objects as parameters
         */
        Border innerBorder = BorderFactory.createTitledBorder("SingleAnswerPlayCard");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        ///////////////////// First Row //////////////////////////////////
        gc.weightx = 1;
        gc.weighty = 1;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        add(questionLabel, gc);

        ///////////////////// Second Row and more//////////////////////////////////
        int gridX = 0;
        int gridY = 1;

        int count = 0;
        for (JRadioButton rBtn : optionsButtonsList) {
            gc.weightx = 1;
            gc.weighty = 1;
            gc.gridx = gridX;
            gc.gridy = gridY;
            gc.anchor = GridBagConstraints.CENTER;
            add(rBtn, gc);
            if (count % 2 == 0){
                gridX++; // move one to the column on the right
            } else {
                gridY++; // get down one row
                gridX = 0; // return the x position (column) to left side
            }
            count++;
        }

        ///////////////////// Last Row //////////////////////////////////
        gc.weightx = 1;
        gc.weighty = 1;
        gc.gridx = 0;
        gc.gridy = gridY;
        gc.anchor = GridBagConstraints.LINE_END;
        add(submitBtn, gc);

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedBtnText = getSelectedButtonText(optionsGroup);
                if (selectedBtnText != null)
                    System.out.println("answer is: " + selectedBtnText);
                else
                    System.out.println("no answer");
            }
        });
    }

    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
}
