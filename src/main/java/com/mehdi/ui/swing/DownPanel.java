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
public class DownPanel extends JPanel {
    public DownPanel(Each2048Cell[][] each2048Cells, int colRow){
        setLayout(new GridLayout(0, colRow));
        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        for(int i=0;i<colRow;++i) {
            for(int j=0;j<colRow;++j) {
                add(each2048Cells[i][j]);
            }
        }
        setSize(100* colRow, 100 * colRow);
    }
}
