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

    private static final int WINNING_SCORE = 2048;

    private final int DIMENSION;
    private final Random random = new Random();

    private int[][] mainGrid;
    private int score;
    private State state = State.NORMAL;

    public Processor(int gridDimension) {
        this(gridDimension, 0);
    }

    public Processor(int gridDimension, int initCellFillNumber) {
        this.DIMENSION = gridDimension;
        mainGrid = new int[gridDimension][gridDimension];
        fillEmptyGridCell(initCellFillNumber);
    }


    private List<Integer> createEmptyGridList() {
        List<Integer> cellList = new ArrayList<Integer>();

        for (int i = 0; i < DIMENSION; ++i) {
            for (int j = 0; j < DIMENSION; ++j) {
                if (mainGrid[i][j] == 0) {
                    cellList.add(DIMENSION * i + j);
                }
            }
        }

        return cellList;
    }


    public int[][] fillEmptyGridCell(int noOfCells) {
        for (int i = 0; i < noOfCells; i++) {
            List<Integer> emptyGridList = createEmptyGridList();
            int emptySeat = emptyGridList.size();

            if (emptySeat == 1) {
                state = State.GAME_OVER;
            }

            //Every turn, a new tile will randomly appear in
            //an empty spot on the board with a value of either 2 or 4. The value 2 will appear with a
            //probability of 90%
            int randomNumber =  (random.nextDouble() < 0.9) ? 2 : 4;
            setEmptyGridCell(emptyGridList.get(random.nextInt(emptySeat)),randomNumber);

        }
        return mainGrid;
    }

    private void setEmptyGridCell(int randomCell, int randomValue) {
        int row = randomCell / DIMENSION;
        int col = randomCell % DIMENSION;
        if (mainGrid[row][col] == 0) {
            mainGrid[row][col] = randomValue;
        }
    }


    public int[][] getCurrentGrid() {
        return mainGrid;
    }

    public State move(Direction direction) {
        AbstractMove movement = null;
        switch (direction) {
            case UP:
                movement = new MoveUp(getCurrentGrid(), DIMENSION);
                break;
            case DOWN:
                movement = new MoveDown(getCurrentGrid(), DIMENSION);
                break;
            case LEFT:
                movement = new MoveLeft(getCurrentGrid(), DIMENSION);
                break;
            case RIGHT:
                movement = new MoveRight(getCurrentGrid(), DIMENSION);
                break;
        }

        AbstractMove ab = movement.start();
        mainGrid = ab.newGrid();
        score += ab.getPoints();

        fillEmptyGridCell(1);
        return getState();
    }

    private State getState() {
        if (state == State.GAME_OVER) {
            return state;
        }

        if (score > WINNING_SCORE) {
            return State.WIN;
        }
        return state;
    }


    public int totalScore() {
        return score;
    }


}

