package com.company.gui.panels;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class BasePanel extends JPanel {

    public BasePanel(String panelName) {
        //each component has a default size
        Dimension dim = getPreferredSize();
        // set the size of the formPanel
        dim.width = 250;
        setPreferredSize(dim);
        /* each graphic element can have a border, with setBorder. In this case, the
         * static method compoundBorder takes two border objects as parameters
         */
        Border innerBorder = BorderFactory.createTitledBorder(panelName);
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
    }
}
