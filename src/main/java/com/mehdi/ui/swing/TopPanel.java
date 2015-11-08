package com.mehdi.ui.swing;

import javax.swing.*;
import java.awt.*;

/**
 * @author Mehdi Afsari Kashi
 * @version 1.0.0
 *          <p/>
 *          Creation Date:  2015/07/16
 * @since 1.0.0
 */
public class TopPanel extends JPanel {

    private JLabel lblScoreName;
    private JLabel lblScoreValue;


    public TopPanel() {
        initComponent();
    }

    private void initComponent() {
        setOpaque(true);
        lblScoreName = new JLabel("SCORE:");

        lblScoreName.setForeground(new Color(187 ,173 ,160));
        lblScoreName.setFont(new Font("Arial", Font.BOLD, 25));

        lblScoreValue = new JLabel();
        lblScoreValue.setFont(new Font("Arial", Font.BOLD, 25));

        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(lblScoreName);
        add(lblScoreValue);
    }

    public void setScoreValue(int scoreValue) {
        lblScoreValue.setText("  " + String.valueOf(scoreValue));
    }
}
