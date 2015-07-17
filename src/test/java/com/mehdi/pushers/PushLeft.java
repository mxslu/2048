package com.mehdi.pushers;

import com.mehdi.core.Direction;
import com.mehdi.core.Processor;
import org.junit.Test;

/**
 * @author Mehdi Afsari Kashi
 * @version 1.0.0
 *          <p/>
 *          Creation Date: 2015/07/17
 * @since 1.0.0
 */
public class PushLeft extends Pusher {

    @Test
    @Override
    public void doPush() {

        //Push left after rotating to 'LEFT'
        int[][] grid = new Processor(4).fillEmptyGridCell(2);
        System.out.println(drawGrid(grid));

        grid = doRotate(grid, Direction.LEFT);
        System.out.println(drawGrid(grid));

        grid = pushLeft(grid);
        System.out.println(drawGrid(grid));

        //Push left after rotating to 'RIGHT'
        int[][] grid2 = new Processor(4).fillEmptyGridCell(2);
        System.out.println(drawGrid(grid2));

        grid2 = doRotate(grid2, Direction.RIGHT);
        System.out.println(drawGrid(grid2));

        grid2 = pushLeft(grid2);
        System.out.println(drawGrid(grid2));
    }
}
