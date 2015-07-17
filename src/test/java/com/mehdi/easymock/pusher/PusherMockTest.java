package com.mehdi.easymock.pusher;

import com.mehdi.core.Processor;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Mehdi Afsari Kashi
 * @version 1.0.0
 *          <p/>
 *          Creation Date: 2015/07/17
 * @since 1.0.0
 */
public class PusherMockTest {

    private Processor processor;
    private PusherMock pusherMock;
    private PusherService pusherService;
    private static final int DIMENSION = 4;

    @Before
    public void init() {
        pusherService = EasyMock.createMock(PusherService.class);
        pusherMock = new PusherMock(pusherService);
        processor = new Processor(DIMENSION, 2);
    }

    @Test
    public void pusherTest() {
        int[][] grid = processor.getCurrentGrid();

        EasyMock.expect(pusherService.getValue()).andReturn(getExpect(grid));
        EasyMock.replay(pusherService);

        assertTrue(pusherMock.isExpectationTrue(grid, DIMENSION));

    }

    /**
     * check if two value in a row of grid are 2 same return 4
     * @param grid
     * @return
     */
    public int getExpect(int[][] grid) {
        List<Integer> numbers = new ArrayList<Integer>();
        int sureNumber = 0;
        int currentCell;
        for (int row = 0; row < grid.length; ++row) {
            int temp = 0;
            for (int col = 0; col < grid[row].length; ++col) {
                currentCell = grid[row][col];
                if (currentCell == 2 || currentCell == 4) {
                    numbers.add(currentCell);
                    sureNumber = currentCell;
                    ++temp;
                }
                if (temp == 2) {
                    if(numbers.get(1) == numbers.get(0)){
                        return numbers.get(1) * 2;
                    }
                }
            }
        }
        return sureNumber;
    }
}
