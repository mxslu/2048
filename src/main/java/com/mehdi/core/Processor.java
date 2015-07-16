package com.mehdi.core;

import com.mehdi.core.puzzle.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Mehdi Afsari Kashi
 * @version 1.0.0
 *          <p/>
 *          Creation Date: 2015/07/16
 * @since 1.0.0
 */
public class Processor {

    private int[][] mainGrid;
    private final int gridDimension;
    private final Random random = new Random();

    public Processor(int gridDimension) {
        this.gridDimension = gridDimension;
        mainGrid = new int[gridDimension][gridDimension];
        fillEmptyGridCell();
    }


    private List<Integer> createEmptyGridList() {
        List<Integer> cellList = new ArrayList<Integer>();

        for (int i = 0; i < gridDimension; ++i) {
            for (int j = 0; j < gridDimension; ++j) {
                if (mainGrid[i][j] == 0) {
                    cellList.add(gridDimension * i + j);
                }
            }
        }

        return cellList;
    }


    private boolean fillEmptyGridCell() {
        List<Integer> emptyGridList = createEmptyGridList();
        int size = emptyGridList.size();

        if (size == 0) {
            return false;
        }

        setEmptyGridCell(emptyGridList.get(random.nextInt(size)), (random.nextDouble() < 0.9) ? 2 : 4);
        return true;
    }

    private void setEmptyGridCell(int randomCell, int randomValue) {
        int row = randomCell / gridDimension;
        int col = randomCell % gridDimension;
        if (mainGrid[row][col] == 0) {
            mainGrid[row][col] = randomValue;
        }
    }


    public int[][] getCurrentGrid() {
        return mainGrid;
    }

    public State move(Direction direction) {
        State state = null;
        Move move = null;
        switch (direction) {
            case UP:
                move = new MoveUp(getCurrentGrid(), gridDimension);
                break;
            case DOWN:
                move = new MoveDown(getCurrentGrid(), gridDimension);
                break;
            case LEFT:
                move = new MoveLeft(getCurrentGrid(), gridDimension);
                break;
            case RIGHT:
                move = new MoveRight(getCurrentGrid(), gridDimension);
                break;
        }

        mainGrid = move.newGrid();
        return null;
    }

    public int computeScore() {
        return 0;
    }


}

