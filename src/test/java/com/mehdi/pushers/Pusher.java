package com.mehdi.pushers;

import com.mehdi.core.Direction;
import com.mehdi.core.puzzle.AbstractMove;

/**
 * @author Mehdi Afsari Kashi
 * @version 1.0.0
 *          <p/>
 *          Creation Date: 2015/07/17
 * @since 1.0.0
 */
public abstract class Pusher {


    public abstract void doPush();

    public String drawGrid(int[][] grid) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < grid.length; ++row) {
            for (int col = 0; col < grid[row].length; ++col) {
                sb.append(grid[row][col] + "\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int[][] doRotate(int[][] grid, Direction direction){

        AbstractMove move = new AbstractMove(grid, grid.length) {

            @Override
            public AbstractMove start() {
                return null;
            }
        };

        int gridRotated[][] = null;
        switch (direction){
            case RIGHT:
                gridRotated = move.rotateRight();
                break;
            case LEFT:
                gridRotated = move.rotateLeft();
                break;
            case UP:
            case DOWN:
                try {
                    throw new Exception("not available");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
                break;
        }

        return gridRotated;
    }

    public int[][] pushLeft(int[][] grid){
        AbstractMove move = new AbstractMove(grid, grid.length) {
            @Override
            public AbstractMove start() {
               return this;
            }
        };
        return move.pusher();
    }
}
