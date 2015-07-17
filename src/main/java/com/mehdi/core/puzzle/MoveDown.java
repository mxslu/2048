package com.mehdi.core.puzzle;

import com.mehdi.core.State;

/**
 * @author Mehdi Afsari Kashi
 * @version 1.0.0
 *          <p/>
 *          Creation Date: 2015/07/16
 * @since 1.0.0
 */
public class MoveDown extends AbstractMove {

    public MoveDown(int[][] grid, int gridDimension) {
        super(grid, gridDimension);
    }

    /**
     * business for moving down the tiles
     * @return
     */
    public AbstractMove start() {
        rotateRight();
        pusher();
        rotateLeft();
        return this;
    }

}
