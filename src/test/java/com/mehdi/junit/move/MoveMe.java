package com.mehdi.junit.move;

import com.mehdi.junit.Drawer;
import com.mehdi.core.Processor;

/**
 * @author Mehdi Afsari Kashi
 * @version 1.0.0
 *          <p/>
 *          Creation Date: 2015/07/17
 * @since 1.0.0
 */
public abstract class MoveMe extends Drawer {

    //get an initial grid
    public int[][] initGrid (int gridDimension, int noOfFillCell){
        Processor processor = new Processor(gridDimension, noOfFillCell);
        return processor.getCurrentGrid();
    }

    public abstract void move();
}
