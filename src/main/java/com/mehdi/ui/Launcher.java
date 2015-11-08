package com.mehdi.ui;

import com.mehdi.ui.console.ConsoleRunner;
import com.mehdi.ui.swing.MainFrame;

/**
 * @author Mehdi Afsari Kashi
 * @version 1.0.0
 *          <p/>
 *          Creation Date:  2015/07/20
 * @since 1.0.0
 */
public class Launcher {

    private enum Mode {
        GUI, CONSOLE
    }

    //Swing UI
    public static void main(String[] args) {
        boot(Mode.GUI);
        //boot(Mode.CONSOLE);
    }

    private static void boot(Mode mode) {
        switch (mode) {
            case GUI:
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        MainFrame frame = new MainFrame("2048 Game", 4);
                        frame.setVisible(true);
                    }
                });
                break;
            case CONSOLE:
                ConsoleRunner.main(null);
                break;

        }
    }
}
