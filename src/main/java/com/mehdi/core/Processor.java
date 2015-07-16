package com.mehdi.core;

import java.util.Random;

/**
 * @author Mehdi Afsari Kashi
 * @version 1.0.0
 *          <p/>
 *          Creation Date: 2015/07/16
 * @since 1.0.0
 */
public class Processor {

    private int[][] mainGrid;
    private int gridDimension;
    private final Random random = new Random();

    public Processor(int gridDimension){
        this.gridDimension = gridDimension;
        mainGrid = new int[gridDimension][gridDimension];
    }


    private void fillEmptyGridCell(){

    }


    public int[][] getCurrentGrid(){
       return mainGrid;
    }

    public int[][] moveUp(){
        return null;
    }

    public int[][] moveDown(){
        return null;
    }

    public int[][] moveLeft(){
        return null;
    }

    public int[][] moveRight(){
        return null;
    }








}

