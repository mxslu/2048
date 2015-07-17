package com.mehdi.core.puzzle;

import com.mehdi.core.State;

/**
 * @author Mehdi Afsari Kashi
 * @version 1.0.0
 *          <p/>
 *          Creation Date: 2015/07/16
 * @since 1.0.0
 */
public abstract class AbstractMove {

    protected int[][] grid;
    private int gridDimension;
    private int points = 0;

    public AbstractMove(int[][] grid, int gridDimension) {
        this.gridDimension = gridDimension;
        this.grid = grid;
    }

    public abstract AbstractMove start();

    public final int[][] pusher() {
        //from right to left check none value zero for pushing to next cell
        for (int row = 0; row < gridDimension; ++row) {
            for (int col = 1; col < gridDimension; ++col) {
                int currentCellValue = grid[row][col];
                if (currentCellValue == 0) {
                    continue;
                }

                //start to the left if its not the first cell value and one cell left has 0 value
                int preCellPosition = col - 1;
                int lastMergePosition = 0;

                for (; preCellPosition > lastMergePosition && grid[row][preCellPosition] == 0;) {
                    --preCellPosition;
                }

                int preCellValue =  grid[row][preCellPosition];

                if (preCellPosition == col) {//we can't start this at all
                } else if (preCellValue == 0) { //start to empty value
                    grid[row][preCellPosition] = currentCellValue;
                    grid[row][col] = 0;
                } else if (preCellValue == currentCellValue) {
                    mergeColumns(row, col, preCellPosition);
                    lastMergePosition  = preCellPosition +1;
                } else if (preCellValue != currentCellValue && preCellPosition + 1 != col) {
                    grid[row][preCellPosition + 1] = grid[row][col];
                    grid[row][col] = 0;
                }
            }
        }

        return grid;
    }


    private void mergeColumns(int row, int col, int previousPosition){
        grid[row][previousPosition] *= 2;
        grid[row][col] = 0;
        points += grid[row][previousPosition];
    }

    public int getPoints() {
        return points;
    }

    public int[][] newGrid() {
        return grid;
    }


    public int[][] rotateRight(){
        int[][] rotatedBoard = new int[gridDimension][gridDimension];

        for(int i=0;i<gridDimension;++i) {
            for(int j=0;j<gridDimension;++j) {
                rotatedBoard[i][j]=grid[gridDimension-j-1][i];
            }
        }

        grid=rotatedBoard;
        return grid;
    }

    public int[][] rotateLeft(){
        int[][] rotatedBoard = new int[gridDimension][gridDimension];

        for(int i=0;i<gridDimension;++i) {
            for(int j=0;j<gridDimension;++j) {
                rotatedBoard[gridDimension-j-1][i] = grid[i][j];
            }
        }

        grid =rotatedBoard;
        return grid;
    }
}
