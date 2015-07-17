package com.mehdi.rotates;

import com.mehdi.core.Processor;
import com.mehdi.core.puzzle.AbstractMove;
import org.junit.Test;

/**
 * @author Mehdi Afsari Kashi
 * @version 1.0.0
 *          <p/>
 *          Creation Date: 2015/07/17
 * @since 1.0.0
 */


public class RotateLeftTest extends Rotater {

    @Test
    public void doRotate() {
        int grid = 4;
        Processor processor = new Processor(grid);
        int[][] firstGrid = processor.fillEmptyGridCell(2);
        System.out.println(draw(firstGrid));
        AbstractMove move = new AbstractMove(firstGrid, grid) {
            @Override
            public AbstractMove start() {
                  return this;
            }
        };

        int[][] secondGrid = move.rotateLeft();
        System.out.println(draw(secondGrid));
    }
}
