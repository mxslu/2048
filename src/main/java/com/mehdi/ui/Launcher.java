package com.mehdi.ui;

import com.mehdi.core.Direction;
import com.mehdi.core.Processor;
import com.mehdi.core.State;

import java.util.InputMismatchException;
import java.util.MissingFormatArgumentException;
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
        tutorial();
        Scanner scanner = new Scanner(System.in);
        int dimension = getDimension(scanner);
        //int fillGridCell = fillerCell(scanner, dimension);

        //in test it said: The game starts with a single tile at a random position on the grid
        starter(dimension, 1 /*fillGridCell*/);
    }

    public static int fillerCell(Scanner scanner, int dimension) {
        int startFillCell = 0;
        try {
            System.out.println("Enter number of starting filled cell: ");
            startFillCell = scanner.nextInt();

            if (startFillCell < 2 && startFillCell > ((int) Math.pow(dimension, 2)) - 1) {
                throw new MissingFormatArgumentException("");
            }
        } catch (MissingFormatArgumentException e) {
            System.err.println("Oops ! You entered a not valid number !!!");
            System.exit(1);
        }

        return startFillCell;
    }

    /**
     * the game will be start using this method
     * @param dimension
     * the starting dimension size
     * @param startFillCell
     * how many tile get fill when the game start
     *
     */
    private static void starter(int dimension, int startFillCell) {
        Scanner scanner = new Scanner(System.in);
        Processor aiCore = new Processor(dimension, startFillCell);

        drawAkaASCIIBoard(aiCore.getCurrentGrid(), aiCore.totalScore());
        State state;
        while (true) {
            String input = scanner.nextLine();

            Direction direction = getDirection(input.charAt(0));
            if (direction == null) {
                continue;
            }

            state = aiCore.move(direction);
            drawAkaASCIIBoard(aiCore.getCurrentGrid(), aiCore.totalScore());

            processCurrentState(state);

        }
    }

    /**
     * check the state of the game
     * @param state
     * show the current state of the game
     * <ol>
     *     <li>NORMAL : means game can continue its normal way</li>
     *     <li>WIN : the required score has been met</li>
     *     <li>GAME_OVER : all of the tiles have value and game stuck and can't move further</li>
     * </ol>
     */
    private static void processCurrentState(State state) {
        switch (state) {
            case NORMAL:
                break;
            case GAME_OVER:
                System.err.println("ΧΧΧ GAME OVER ΧΧΧ");
                System.exit(0);
            case WIN:
                System.out.println("*** Congratulation You WON ***");
                System.exit(0);
        }
    }

    /**
     * just some description about the game
     */
    private static void tutorial() {
        System.out.println("Welcome to 2048 Game");
        System.out.println("Instruction :");
        System.out.println("\t\u2191");
        System.out.println("\tW");
        System.out.println("\u2190A\t\tD\u2192");
        System.out.println("\tS");
        System.out.println("\t\u2193\n");
        System.out.println("in each phase you can terminate the game by entering 'Q'\n");
        System.out.println("Starting ...\n========================================\n");
    }

    /**
     *
     * this method will get the square grid size from the user
     * @param out
     * @return
     */
    private static int getDimension(Scanner out) {

        /*
         When the game starts the user is asked for
         the size of the square grid he/she wants to play on (minimum size is 4x4 , this size should
         be offered as default).
         */
        System.out.println("what is your desired size of the square grid ? (you number should be 4 or above)");
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


    /**
     * this method just get the provided grid and current game score and display it into the console
     * @param grid
     * @param currentScore
     */
    private static void drawAkaASCIIBoard(int[][] grid, int currentScore) {
        System.out.println();

        System.out.println("Score:  " + currentScore + "\n");

        for (int row = 0; row < grid.length; ++row) {
            for (int col = 0; col < grid[row].length; ++col) {
                System.out.print(grid[row][col] + "\t");
            }
            System.out.println();
        }
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    /**
     * this method will get the Direction according to user input
     * @param inputChar
     * @return
     */
    private static Direction getDirection(char inputChar) {

        //the user can enter
        //moves using the keyboard keys 'a' (left) , 'd' (right) , 'w' (up) and 's' (down)

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
            System.err.println("You input '" + inputChar + "' is a wrong input ~");
        }
        return direction;
    }
}
