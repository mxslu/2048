package com.mehdi.easymock.rotates;

import com.mehdi.core.Direction;
import com.mehdi.core.Processor;
import com.mehdi.core.puzzle.AbstractMove;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Mehdi Afsari Kashi
 * @version 1.0.0
 *          <p/>
 *          Creation Date: 2015/07/17
 * @since 1.0.0
 */
public class RotateMockTest {

    private RotateService rotateService;
    private static final int DIMENSION = 4;
    private Processor processor;
    private RotateMock rotateMock;

    @Before
    public void init() {
        rotateService = EasyMock.createMock(RotateService.class);
        processor = new Processor(DIMENSION, 2);
        rotateMock = new RotateMock(rotateService);
    }

    /**
     * test whether the mock provided values are the same
     * when 2 rotates from different sides applied on a grid
     * or not
     */
    @Test
    public void testRotate() {
        int[][] grid = processor.getCurrentGrid();

        EasyMock.expect(rotateService.rotateRight()).andReturn(doubleRotation(grid, Direction.RIGHT));
        EasyMock.expect(rotateService.rotateLeft()).andReturn(doubleRotation(grid, Direction.LEFT));
        EasyMock.replay(rotateService);

        assertTrue(rotateMock.isEqual());
    }

    /**
     * rotate a grid twice in given direction
     *
     * @param grid
     * @param direction
     *
     * @return
     */
    private int[][] doubleRotation(int[][] grid, Direction direction) {
        AbstractMove abstractMove = new AbstractMove(grid, DIMENSION) {
            @Override
            public AbstractMove start() {
                return null;
            }
        };

        switch (direction) {
            case RIGHT:
                abstractMove.rotateRight();
                abstractMove.rotateRight();
                break;

            case LEFT:
                abstractMove.rotateLeft();
                abstractMove.rotateLeft();
                break;
            case UP:
            case DOWN:
                try {
                    throw new Exception("there's only left and right" +
                            " rotation, please change your direction to [LEFT / RIGHT] " +
                            "for getting the right result !");
                } catch (Exception e) {
                    e.printStackTrace();
                }

        }
        return abstractMove.newGrid();
    }

}
