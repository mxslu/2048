package com.mehdi;

import com.mehdi.core.Direction;
import com.mehdi.core.Processor;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Mehdi Afsari Kashi
 * @version 1.0.0
 *          <p/>
 *          Creation Date: 2015/07/16
 * @since 1.0.0
 */
public class Launcher {

    public static void main(String[] args) {
        starter();
    }

    private static void starter() {
        tutorial();
        Scanner out = new Scanner(System.in);

        int dimension = getDimension(out);
        while (true) {
            Processor aiCore = new Processor(dimension);

            switch (getDirection(out.findInLine(".").charAt(0))) {
                case UP:
                    aiCore.moveUp();
                    break;
                case DOWN:
                    aiCore.moveDown();
                    break;
                case LEFT:
                    aiCore.moveLeft();
                    break;
                case RIGHT:
                    aiCore.moveRight();
                    break;
                case NO_where:
                    continue;
            }

            drawAkaASCIIBoard(aiCore.getCurrentGrid());
        }


    }

    private static void tutorial() {
        System.out.println("Welcome to 2048 Game");
        System.out.println("Instruction :");
        System.out.println("\t\u2191");
        System.out.println("\tW");
        System.out.println("\u2190A\t\tD\u2192");
        System.out.println("\tS");
        System.out.println("\t\u2193\n");
        System.out.println("After each character press enter !!!");
        System.out.println("Starting ...\n========================================\n");
    }

    private static int getDimension(Scanner out) {
        System.out.println("what is your desire game dimension : (you number should be 4 or above)");
        int dimension = 0;
        try {
            dimension = out.nextInt();
            if (dimension < 4) {
                System.err.println("You are not allowed to enter a number less than 4 ~");
                System.exit(1);
            }
        } catch (InputMismatchException e) {
            System.err.println("System Error!!! \nYou have entered a not valid number ~");
            System.exit(1);
        }

        return dimension;
    }

    private static void drawAkaASCIIBoard(int[][] grid) {
        System.out.println();

        for (int row = 0; row < grid.length; ++row) {
            for (int col = 0; col < grid[row].length; ++col) {
                System.out.print(grid[row][col] + "\t");
            }
            System.out.println();
        }
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~");
    }

    private static Direction getDirection(char inputChar) {
        Direction direction = null;
        if (inputChar == 'a' || inputChar == 'A') {
            direction = Direction.LEFT;
        } else if (inputChar == 's' || inputChar == 'S') {
            direction = Direction.DOWN;
        } else if (inputChar == 'd' || inputChar == 'D') {
            direction = Direction.RIGHT;
        } else if (inputChar == 'w' || inputChar == 'W') {
            direction = Direction.UP;
        } else if (inputChar == 'q' || inputChar == 'Q') {
            System.out.println("See You ~");
            System.exit(0);
        } else {
            System.out.println("You input '" + inputChar + "' is a wrong input ~");
        }
        return direction;
    }
}
