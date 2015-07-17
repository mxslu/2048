package com.mehdi;

/**
 * @author Mehdi Afsari Kashi
 * @version 1.0.0
 *          <p/>
 *          Creation Date: 2015/07/17
 * @since 1.0.0
 */
public abstract class Drawer {

    public final String draw(int[][] grid) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < grid.length; ++row) {
            for (int col = 0; col < grid[row].length; ++col) {
                sb.append(grid[row][col] + "\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
