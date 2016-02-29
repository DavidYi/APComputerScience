package lab0101;

import java.util.Scanner;

/**
 * Created by David on 12/15/2015.
 */
public class Life {

    public void startCell(String start, boolean[][] cell, int width, int height) {
        // Put the initial string into the array

        String[] noLine = start.split("\n");
        // separate the input "life form" by newline into an array
        String[][] single = new String[height][]; // will separate each line and
        // in each line separate
        // each character
        int startx = (cell[30].length - width) / 2; // max width
        int starty = (cell.length - height) / 2; // max height

        // separate each char per line and add it in array form
        for (int i = 0; i < noLine.length; i++)
            single[i] = noLine[i].split("");

        // adds the asterisks into the array
        for (int y = 0; y < single.length; y++) {
            for (int x = 0; x < single[y].length; x++) {
                if (single[y][x].equals("*"))
                    cell[y + starty][x + startx] = true;
            }
        }
    }

    public void updateCell(boolean[][] grid) {// update the cell according to
        // the rule
        int neighbors = 0; // number of neighbors

        // copies cell, so that if we change cell to have the asterisks, then it
        // won't affect the other ones
        boolean[][] oldGrid = new boolean[60][200];

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                oldGrid[y][x] = grid[y][x];
            }
        }

        // where the real update happens
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                neighbors = 0;

                // how many neighbors there are for a place on the grid
                if (x > 0) {// stop negative index error for x
                    if (y < oldGrid.length - 1) // stop outofbounds error for y
                        if (oldGrid[y + 1][x - 1])
                            neighbors++;

                    if (oldGrid[y][x - 1])
                        neighbors++;

                    if (y > 0) // stop negative index error for y
                        if (oldGrid[y - 1][x - 1])
                            neighbors++;
                }
                if (x < oldGrid[y].length - 1) {// stop outofbounds error for x
                    if (y < oldGrid.length - 1) // stop outofbounds error for y
                        if (oldGrid[y + 1][x + 1])
                            neighbors++;

                    if (oldGrid[y][x + 1])
                        neighbors++;

                    if (y > 0) // stop negative index error for y
                        if (oldGrid[y - 1][x + 1])
                            neighbors++;
                }

                if (y < oldGrid.length - 1) // stop outofbounds error for y
                    if (oldGrid[y + 1][x])
                        neighbors++;

                if (y > 0) // stop negative index for y
                    if (oldGrid[y - 1][x])
                        neighbors++;
                // end of finding how many neighbors

                // updates to have or not have asterisks if condition fulfilled
                if (grid[y][x] && (neighbors < 2 || neighbors > 3))
                    grid[y][x] = false;
                else if (!grid[y][x] && neighbors == 3)
                    grid[y][x] = true;

            }
        }

    }

    public void printCell(boolean[][] grid) {//print the cell onto screen
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++)
                if (grid[y][x])//if has asterisk then print asterisk
                    System.out.print("*");
                else//if not then print space
                    System.out.print(" ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //variable to be used
        boolean[][] grid = new boolean[60][200];
        int n = 1, numLine = 0, biggestWidth = 0;
        String startCells, temp = "", choice;

        //creates instances since this is static method
        Scanner input = new Scanner(System.in);
        Life life = new Life();

        //creates default
        for (int y = 0; y < grid.length; y++)
            for (int x = 0; x < grid[y].length; x++)
                grid[y][x] = false;


        System.out.println(
                "Enter starting arrangement of spaces, asterisks and returns, followed by a line with the letter \"Q\" to start the simulator:");
        startCells = input.nextLine();
        while (!startCells.equals("Q")) {
            if (biggestWidth < startCells.length())
                biggestWidth = startCells.length();
            numLine++;
            temp += startCells + "\n";
            startCells = input.nextLine();
        }
        startCells = temp;

        life.startCell(startCells, grid, biggestWidth, numLine);

        System.out.println("--------------------------------------------------------\n");

        boolean forever = false;
        while ((forever) || (n > 0)) {
            life.printCell(grid);
            life.updateCell(grid);

            n--;
            if ((!forever) && (n == 0)) {
                System.out.println(
                        "Input g for \"go forever\", an integer n for n generations, or enter for the next step:");
                choice = input.nextLine();

                try {
                    n = Integer.parseInt(choice);
                } catch (NumberFormatException e) {
                    if (choice.equals("g"))
                        forever = true;
                    else if (choice.equals(""))
                        n = 1;
                    else {
                        System.out.println();
                    }
                }
            }
        } // end of while loop
    }

}
