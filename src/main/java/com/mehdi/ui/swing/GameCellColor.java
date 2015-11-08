package com.mehdi.ui.swing;

import java.awt.*;

/**
 * @author Mehdi Afsari Kashi
 * @version 1.0.0
 *          <p/>
 *          Creation Date:  2015/07/16
 * @since 1.0.0
 */
public enum GameCellColor {
    BORDER_COLOR(new Color(187, 173, 160)),

    NUMBER_0(new Color(205, 192, 180)),
    NUMBER_2(new Color(238, 228, 218)),
    NUMBER_4(new Color(237, 224, 200)),
    NUMBER_8(new Color(242, 177, 121)),
    NUMBER_16(new Color(245 ,149 ,99)),
    NUMBER_32(new Color(246, 124, 95)),
    NUMBER_64(new Color(246, 94, 59)),
    NUMBER_128(new Color(237, 207, 114)),
    NUMBER_256(new Color(237, 204, 97)),
    NUMBER_512(new Color(237, 200, 80)),
    NUMBER_1024(new Color(237, 197, 64)),
    NUMBER_2048(new Color(237, 194, 46)),
    NUMBER_4096(new Color(238, 228, 218));



    private Color color;


    private GameCellColor(Color color){
        this.color = color;
    }

    public static final Color getColor(int number){
        switch (number){
            case -1:
                return BORDER_COLOR.color;
            case 0:
                return NUMBER_0.color;
            case 2:
                return NUMBER_2.color;
            case 4:
                return NUMBER_4.color;
            case 8:
                return NUMBER_8.color;
            case 16:
                return NUMBER_16.color;
            case 32:
                return NUMBER_32.color;
            case 64:
                return NUMBER_64.color;
            case 128:
                return NUMBER_128.color;
            case 256:
                return NUMBER_256.color;
            case 512:
                return NUMBER_512.color;
            case 1024:
                return NUMBER_1024.color;
            case 2048:
                return NUMBER_2048.color;
            case 4096:
                return NUMBER_4096.color;
        }
        return null;
    }
}
