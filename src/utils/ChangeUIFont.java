package utils;

import javax.swing.*;

public class ChangeUIFont
{
    public static void setUIFont (javax.swing.plaf.FontUIResource f){
        /**
         * change the font all element in the program
         */
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get (key);
            if (value instanceof javax.swing.plaf.FontUIResource)
                UIManager.put (key, f);
        }
    }

}
