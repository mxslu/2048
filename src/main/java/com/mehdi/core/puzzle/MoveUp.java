package com.mehdi.core.puzzle;

import com.mehdi.core.State;

/**
 * @author Mehdi Afsari Kashi
 * @version 1.0.0
 *          <p/>
 *          Creation Date: 2015/07/16
 * @since 1.0.0
 */
public class MoveUp extends AbstractMove {

    public MoveUp(int[][] grid, int gridDimension) {
        super(grid, gridDimension);
    }

    /**
     * business for moving up the tiles
     * @return
     */
    public AbstractMove start() {
        rotateLeft();
        pusher();
        rotateRight();
        return this;
    }
}
