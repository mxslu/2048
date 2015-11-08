package com.mehdi.ui.swing;

import com.mehdi.core.Direction;
import com.mehdi.core.Processor;
import com.mehdi.core.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Mehdi Afsari Kashi
 * @version 1.0.0
 *          <p/>
 *          Creation Date:  2015/07/16
 * @since 1.0.0
 */
public class MainFrame extends JFrame {
    public final static boolean RIGHT_TO_LEFT = false;
    private Processor processor;
    private TopPanel topPanel;
    private Each2048Cell[][] swingGridCells;
    private int colRow;

    public MainFrame(String title, int colRow) {
        this.colRow = colRow;
        processor = initProcessor();
        initComponents(title);

    }

    private void initComponents(String title) {
        setTitle(title);
        Container pane = getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }

        pane.setLayout(new BorderLayout());

        int[][] eachCellList = processor.getCurrentGrid();
        DownPanel downPanel = new DownPanel(createInitialGrid(eachCellList), colRow);

        topPanel = new TopPanel();

        add(topPanel, BorderLayout.NORTH);
        add(downPanel, BorderLayout.CENTER);

        setSize(colRow * 100, colRow * 100);

        addKeyListener(new KeyListener());
    }

    private class KeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            State gameState = null;

            switch (e.getKeyCode()) {
                case KeyEvent.VK_KP_LEFT:
                case KeyEvent.VK_LEFT:
                    gameState=  processor.move(Direction.LEFT);
                    break;

                case KeyEvent.VK_KP_RIGHT:
                case KeyEvent.VK_RIGHT:
                    gameState=  processor.move(Direction.RIGHT);
                    break;
                case KeyEvent.VK_KP_UP:
                case KeyEvent.VK_UP:
                    gameState=  processor.move(Direction.UP);
                    break;

                case KeyEvent.VK_KP_DOWN:
                case KeyEvent.VK_DOWN:
                    gameState=  processor.move(Direction.DOWN);
                    break;
            }
            topPanel.setScoreValue(processor.totalScore());

            fillSwingGrid(processor.getCurrentGrid(), swingGridCells);
            if (gameState != null) appDecider(gameState);
        }
    }

    private void appDecider(State gameState) {
        switch (gameState) {
            case WIN:
                JOptionPane.showMessageDialog(null, "You Won");
                break;

            case GAME_OVER:
                JOptionPane.showMessageDialog(null, "You Have Game Over");
                break;
        }
    }

    private Each2048Cell[][] createInitialGrid(int[][] gridInteger) {
        Each2048Cell[][] grid = new Each2048Cell[colRow][colRow];
        for (int i = 0; i < colRow; ++i) {
            for (int j = 0; j < colRow; ++j) {
                grid[i][j] = new Each2048Cell();
                grid[i][j].setNumber(gridInteger[i][j]);
            }
        }

         swingGridCells = grid;
        return grid;
    }

    private Each2048Cell[][] fillSwingGrid(int[][] gridInteger, Each2048Cell[][] swingGrid) {

        for (int i = 0; i < colRow; ++i) {
            for (int j = 0; j < colRow; ++j) {
                swingGrid[i][j].setNumber(gridInteger[i][j]);
            }
        }

        swingGridCells = swingGrid;
        return swingGrid;
    }

    public Processor initProcessor() {
        return  new Processor(colRow, 2);
    }
}
