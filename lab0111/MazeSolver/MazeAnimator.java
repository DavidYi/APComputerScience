package lab0111.MazeSolver;

import java.util.Scanner;

/**
 * Created by David on 2/23/2016.
 */
public class MazeAnimator {
    public static void printMaze(String[][] asciiMaze) {
        for (int y = 0; y < asciiMaze.length; y++) {
            for (int x = 0; x < asciiMaze.length; x++)
                System.out.print(asciiMaze[y][x]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        MazeGenerator m;

        //asking user whether they want to solve maze
        System.out.println("Would you like me to solve the maze. If so, then press enter. Otherwise, type in anything else.");
        String response = input.nextLine().toLowerCase();

        //make a new maze as long as response != q
        while (response.equals("")) {
            System.out.println("Enter size do you want the sides of the maze to be.");
            int size = input.nextInt();

            m = new MazeGenerator(size);

            //if yes, generating a maze
            m.generate();

            //getting the int/ascii maze
            String[][] asciiMaze = m.mazeToStringArray();
            int[][] maze = m.getMaze();

            //printing blank maze
            printMaze(asciiMaze);


            //setting our current position in the maze for reference
            int x = 1;
            int y = 1;

            //getting the direction by inputting our int[][] maze into solveMaze function
            MazeSolver s = new MazeSolver(maze);
            char[] directions = s.solveMaze();

            asciiMaze[y][x] = "* ";
            //going through direction array
            for (int i = 0; i < directions.length - 1; i++) {
                //changing our position in maze depending on direction (RIGHT/left/UP/DOWN)
                char temp = directions[i];

                if (temp == 'r')
                    x++;
                else if (temp == 'l')
                    x--;
                else if (temp == 'u')
                    y--;
                else if (temp == 'd')
                    y++;

                //setting a "*" in the direction we must take next and printing maze
                asciiMaze[y][x] = "* ";
                printMaze(asciiMaze);
                try {
                    Thread.sleep(500);
                }catch(InterruptedException e){
                    System.out.println("got interrupted!");
                }
            }

            //final maze has been printed
            //clearing maze, so we can generate a new one
            m.clear();

            //asking user whether they want to solve another maze
            System.out.println("Would you like me to solve a maze again. If so, then press enter. Otherwise, type in anything else.");
            input.nextLine();
            response = input.nextLine().toLowerCase();
        }
    }
}