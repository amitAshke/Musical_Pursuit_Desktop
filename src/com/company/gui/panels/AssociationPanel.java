package com.company.gui.panels;

import com.company.PlayCardPackage.AssociationPlayCard;
import com.company.gui.GameWindow;
import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;


public class AssociationPanel extends BasePanel implements ActionListener {

    private AssociationPlayCard playCard;
    private Iterator it;
    private JPanel oneAssociateQuestionPanel;
    private JButton submitBtn;

    public AssociationPanel(AssociationPlayCard playCard) {
        super("Association Play Card");
        this.playCard = playCard;
        JLabel questionLabel = new JLabel(playCard.getQuestion());
        it = playCard.getAssociations().entrySet().iterator();
        // get first question
        Map.Entry pair = (Map.Entry)it.next();
        //one question panel
        oneAssociateQuestionPanel = new OneAssociatePanel(playCard.getBandsOptions(), pair);

        submitBtn = new JButton("Submit");
        submitBtn.setEnabled(false); // btn will be available to click at the end
        submitBtn.addActionListener(this);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        ///////////////////// First Row //////////////////////////////////
        add(questionLabel);

        ///////////////////// Second Row//////////////////////////////////
        add(oneAssociateQuestionPanel);

        ///////////////////// Third Row//////////////////////////////////
        add(submitBtn);

    }

    void nextAssociateQuestion(Pair<Integer, Integer> correctAnswerUserAnswer) {
        // key is correct answer, value is user
        if (correctAnswerUserAnswer.getKey().equals(correctAnswerUserAnswer.getValue())) {
            System.out.println("well done! :)");
        } else {
            System.out.println("incorrect :(");
        }

        if (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            this.remove(oneAssociateQuestionPanel); // remove the old panel
            this.remove(submitBtn); // remove the btn

            this.oneAssociateQuestionPanel = new OneAssociatePanel(playCard.getBandsOptions(), pair);
            add(oneAssociateQuestionPanel);
            add(submitBtn); // re add the btn

        } else { //no more associate question
            this.remove(oneAssociateQuestionPanel); // remove the old panel
            this.remove(submitBtn); // remove the btn
            add(new BasePanel("Click Submit"));
            add(submitBtn);
            this.submitBtn.setEnabled(true);
        }

        //make sure it will draw the new panel
        this.validate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnClicked = (JButton)e.getSource();
        if (btnClicked == submitBtn) {
            System.out.println("end of associate level");
            ((GameWindow)javax.swing.FocusManager.getCurrentManager().getActiveWindow()).callNextQuestion();
        }
    }
}