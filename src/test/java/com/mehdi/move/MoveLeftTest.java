package com.mehdi.move;

import com.mehdi.core.puzzle.AbstractMove;
import com.mehdi.core.puzzle.MoveLeft;
import org.junit.Test;

/**
 * @author Mehdi Afsari Kashi
 * @version 1.0.0
 *          <p/>
 *          Creation Date: 2015/07/17
 * @since 1.0.0
 */
public class MoveLeftTest extends MoveMe {

    /**
     * display moving left behavior
     */
    @Test
    public void move() {
        int dimension = 4;
        int [][] initGrid = initGrid(dimension, 2);
        System.out.println(draw(initGrid));

        AbstractMove move = new MoveLeft(initGrid, dimension);
        int[][] gridAfterUpMove = move.start().newGrid();
        System.out.println(draw(gridAfterUpMove));
    }
}
