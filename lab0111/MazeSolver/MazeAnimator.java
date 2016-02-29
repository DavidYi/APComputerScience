package lab0111.MazeSolver;

import java.util.Scanner;

/**
 * Created by David on 2/23/2016.
 */
public class MazeAnimator {
    public static void printMaze(String[][] asciiMaze) {
        for (int y = 0; y < asciiMaze.length; y++)
            for (int x = 0; x < asciiMaze[y].length; x++){
                if (x == 0)
                    System.out.println();
                System.out.print(asciiMaze[y][x]);
            }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        MazeGenerator m = new MazeGenerator();

        m.generate();

        //getting the int/ascii maze
        String[][] asciiMaze = m.mazeToStringArray();
        int[][] maze = m.getMaze();

        //printing blank maze with start and ending point
        printMaze(asciiMaze);

        //asking user whether they want to solve maze
        System.out.println("Do you want to solve a maze? If so, press enter. If not, enter q.");
        String response = input.nextLine().toLowerCase();
        int size;

        /*
        //make a new maze as long as response != q
        while (!(response.equals("q"))) {
            System.out.println("Enter the side length you want your maze to be.");
            size = input.nextInt();

            m.setSide(size);

            //if yes, generating a maze
            m.generate();

            //getting the int/ascii maze
            String[][] asciiMaze = m.mazeToStringArray();
            int[][] maze = m.getMaze();

            //printing blank maze with start and ending point
            printMaze(asciiMaze);

            //setting our current position in the maze for reference
            int x = 1;
            int y = 1;

            //getting the directions by inputting our int[][] maze into solveMaze funtion
            String[] directions = solveMaze(maze);


            System.out.println("Press enter when you want me to solve the maze");
            input.nextLine();

            //going through directions array
            for (int i = directions.length - 1; i >= 0; i++) {
                //changing our position in maze depending on direction (right/left/up/down)
                switch (directions[i]) {
                    case "r":
                        x++;
                        break;
                    case "l":
                        x--;
                        break;
                    case "u":
                        y--;
                        break;
                    case "d":
                        y++;
                        break;
                    default:
                        System.out.println("Oops, something went wrong!");
                        break;
                }

                //setting a "*" in the direction we must take next and printing maze
                asciiMaze[x][y] = "* ";
                printMaze(asciiMaze);
            }

            //final maze has been printed
            //clearing maze, so we can generate a new one
            m.clear();

            //asking user whether they want to solve another maze
            System.out.println("Do you want to solve another maze? If so, press enter. If not, enter q.");
            response = input.nextLine();
        }*/
    }
}