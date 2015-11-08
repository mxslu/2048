package com.mehdi.ui.swing;

import javax.swing.*;
import java.awt.*;

/**
 * @author Mehdi Afsari Kashi
 * @version 1.0.0
 *          <p/>
 *          Creation Date:  2015/07/20
 * @since 1.0.0
 */

public class Each2048Cell extends JButton {
    private int number;

    public Each2048Cell() {
        setBackground(GameCellColor.getColor(number));
        setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, GameCellColor.getColor(-1)));
        setFont(new Font("Arial", Font.BOLD, 25));
        setEnabled(false);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        setText(number == 0 ? "" : String.valueOf(number));
        setBackground(GameCellColor.getColor(number));
        this.number = number;


        if (number == 0) {
        } else if (number == 2 || number == 4) {
            setForeground(new Color(119, 110, 101));
        } else {
            setForeground(Color.WHITE);
        }
    }
}
