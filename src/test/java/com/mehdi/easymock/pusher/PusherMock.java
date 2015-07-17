package com.mehdi.easymock.pusher;

import com.mehdi.core.puzzle.AbstractMove;

/**
 * @author Mehdi Afsari Kashi
 * @version 1.0.0
 *          <p/>
 *          Creation Date: 2015/07/17
 * @since 1.0.0
 */
public class PusherMock {

    private PusherService pusherService;

    public PusherMock(PusherService pusherService) {
        this.pusherService = pusherService;
    }

    /**
     * this method will push the grid into the left and compare the
     * values with expected mock value
     * @param grid
     * @param dimension
     * @return
     */
    public boolean isExpectationTrue(int[][] grid, int dimension) {
        AbstractMove move = new AbstractMove(grid, dimension) {
            @Override
            public AbstractMove start() {
                return null;
            }
        };

        int[][] pushed = move.pusher();
        int mockValue = pusherService.getValue();

        /*
        because we have only 2 value in our grid at the beginning
        they are whether 2 or four
        when they merge 4 , when they don't 2
        our mock value is 4 when they are in same row
        our test push the value and compare with expected
        PusherService value */
        for (int row = 0; row < pushed.length; ++row) {
            for (int col = 0; col < pushed[row].length; ++col) {
                if (mockValue == pushed[row][col]) {
                    return true;
                }
            }

        }

        return false;
    }
}
