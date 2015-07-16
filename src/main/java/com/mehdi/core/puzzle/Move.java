package com.mehdi.core.puzzle;

import com.mehdi.core.State;

/**
 * @author Mehdi Afsari Kashi
 * @version 1.0.0
 *          <p/>
 *          Creation Date: 2015/07/16
 * @since 1.0.0
 */
public abstract class Move {

    protected int[][] grid;
    private int gridDimension;
    private int points = 0;

    public Move(int[][] grid, int gridDimension) {
        this.gridDimension = gridDimension;
        this.grid = grid;
    }

    protected abstract State move();

    public void moveDecider() {

    }




    public int getPoints() {
        return points;
    }

    public int[][] newGrid() {
        return grid;
    }


    protected void rotateLeft90(){
        int[][] rotatedBoard = new int[gridDimension][gridDimension];

        for(int i=0;i<gridDimension;++i) {
            for(int j=0;j<gridDimension;++j) {
                rotatedBoard[i][j]=grid[gridDimension-j-1][i];
            }
        }

        grid=rotatedBoard;
    }

    protected void rotateRight(){
        int[][] rotatedBoard = new int[gridDimension][gridDimension];

        for(int i=0;i<gridDimension;++i) {
            for(int j=0;j<gridDimension;++j) {
                rotatedBoard[gridDimension-j-1][i] = grid[i][j];
            }
        }

        grid =rotatedBoard;
    }
}
