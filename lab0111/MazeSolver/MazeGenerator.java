package lab0111.MazeSolver;

import java.util.Random;

/**
 * Created by David on 2/3/2016.
 */

class Point{
    protected int x, y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class MazeGenerator {
    //-1 is wall, 0 is path, start is 0,0 and end is side, side
    private int[][] maze;
    //dimensions of the maze
    protected int side = 5;

    //used in the Recursive Back tracker Maze Generator method
    private Point[] stack;
    protected int sp;

    //these constants will be used in the checkEdge method
    private final int LEFT_EDGE = 1;
    private final int RIGHT_EDGE = 4;
    private final int TOP_EDGE = 2;
    private final int BOTTOM_EDGE = 3;
    private final int TL_CORNER = -1;
    private final int BL_CORNER = -2;
    private final int TR_CORNER = -3;
    private final int BR_CORNER = -4;
    private final int NOT_EDGE = 0;

    //the items that will be in the maze array
    private final int WALL = -1;
    private final int NOT_WALL = 0;

    public MazeGenerator(int side) {
        this.side = side;
        stack = new Point[side * side];
        maze = new int[side * 2 - 1][side * 2 - 1];
        sp = 0;  // stack pointer

        //defaults the space in the maze to be walls
        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze.length; x++) {
                maze[y][x] = WALL;
            }
        }

        //sets the starting point (always the 0,0) to be a space
        maze[0][0] = NOT_WALL;
        //put the starting point on the stack
        stack[sp++] = new Point(0, 0);

        //the destination is always the length - 1, length - 1
    }

    private int checkEdge(int x, int y){
        int whichEdge = NOT_EDGE; //if the coordinates isn't an edge
        if (x == 0) {
            whichEdge = LEFT_EDGE;

            if (y == 0)
                whichEdge = TL_CORNER;
            else if(y == maze.length - 1)
                whichEdge = BL_CORNER;

        } else if (x == maze.length - 1) {
            whichEdge = RIGHT_EDGE;

            if (y == 0)
                whichEdge = TR_CORNER;
            else if(y == maze.length - 1)
                whichEdge = BR_CORNER;

        } else if (y == 0)
            whichEdge = TOP_EDGE;
        else if (y == maze.length - 1)
            whichEdge = BOTTOM_EDGE;

        return whichEdge;
    }

    public void generate() {
        Random rand = new Random();

        int mazeX = 0, mazeY = 0; //coordinates of the old space
        int wallX, wallY;//the coordinates of the wall between the known and new spaces
        int neighborCount; //counts the neighbors
        int isEdge; //used to get the result of checkEdge
        char[] neighbors;
        int dir;

        while (sp != 0) {//checks if the stack is empty
            neighborCount = 0;
            neighbors = new char[4];
            isEdge = checkEdge(mazeX, mazeY);
            wallX = mazeX;
            wallY = mazeY;

            if (isEdge == NOT_EDGE) {
                if (maze[mazeY][mazeX + 2] == WALL)
                    neighbors[neighborCount++] = 'r';
                if (maze[mazeY + 2][mazeX] == WALL)
                    neighbors[neighborCount++] = 'd';
                if (maze[mazeY - 2][mazeX] == WALL)
                    neighbors[neighborCount++] = 'u';
                if (maze[mazeY][mazeX - 2] == WALL)
                    neighbors[neighborCount++] = 'l';

                if (neighborCount != 0) {
                    dir = rand.nextInt(neighborCount);

                    if (neighbors[dir] == 'u') {//go UP
                        mazeY -= 2;
                        wallY--;
                    } else if (neighbors[dir] == 'r') {//go RIGHT
                        mazeX += 2;
                        wallX++;
                    } else if (neighbors[dir] == 'd') {//go DOWN
                        mazeY += 2;
                        wallY++;
                    } else if (neighbors[dir] == 'l') {//go left
                        mazeX -= 2;
                        wallX--;
                    }
                }
            } else if (isEdge == LEFT_EDGE) {
                if (maze[mazeY][mazeX + 2] == WALL)
                    neighbors[neighborCount++] = 'r';
                if (maze[mazeY + 2][mazeX] == WALL)
                    neighbors[neighborCount++] = 'd';
                if (maze[mazeY - 2][mazeX] == WALL)
                    neighbors[neighborCount++] = 'u';

                if (neighborCount != 0) {
                    dir = rand.nextInt(neighborCount);

                    if (neighbors[dir] == 'u') {//go UP
                        mazeY -= 2;
                        wallY--;
                    } else if (neighbors[dir] == 'r') {//go RIGHT
                        mazeX += 2;
                        wallX++;
                    } else if (neighbors[dir] == 'd') {//go DOWN
                        mazeY += 2;
                        wallY++;
                    }
                }
            } else if (isEdge == TOP_EDGE) {
                if (maze[mazeY][mazeX + 2] == WALL)
                    neighbors[neighborCount++] = 'r';
                if (maze[mazeY + 2][mazeX] == WALL)
                    neighbors[neighborCount++] = 'd';
                if (maze[mazeY][mazeX - 2] == WALL)
                    neighbors[neighborCount++] = 'l';

                if (neighborCount != 0) {
                    dir = rand.nextInt(neighborCount);

                    if (neighbors[dir] == 'l') {//go left
                        mazeX -= 2;
                        wallX--;
                    } else if (neighbors[dir] == 'd') {//go DOWN
                        mazeY += 2;
                        wallY++;
                    } else if (neighbors[dir] == 'r') {//go RIGHT
                        mazeX += 2;
                        wallX++;
                    }
                }
            } else if (isEdge == BOTTOM_EDGE) {
                if (maze[mazeY][mazeX + 2] == WALL)
                    neighbors[neighborCount++] = 'r';
                if (maze[mazeY - 2][mazeX] == WALL)
                    neighbors[neighborCount++] = 'u';
                if (maze[mazeY][mazeX - 2] == WALL)
                    neighbors[neighborCount++] = 'l';

                if (neighborCount != 0) {
                    dir = rand.nextInt(neighborCount);

                    if (neighbors[dir] == 'l') {//go left
                        mazeX -= 2;
                        wallX--;
                    } else if (neighbors[dir] == 'u') {//go UP
                        mazeY -= 2;
                        wallY--;
                    } else if (neighbors[dir] == 'r') {//go RIGHT
                        mazeX += 2;
                        wallX++;
                    }
                }
            } else if (isEdge == RIGHT_EDGE) {
                if (maze[mazeY + 2][mazeX] == WALL)
                    neighbors[neighborCount++] = 'd';
                if (maze[mazeY - 2][mazeX] == WALL)
                    neighbors[neighborCount++] = 'u';
                if (maze[mazeY][mazeX - 2] == WALL)
                    neighbors[neighborCount++] = 'l';

                if (neighborCount != 0) {
                    dir = rand.nextInt(neighborCount);

                    if (neighbors[dir] == 'u') {//go UP
                        mazeY -= 2;
                        wallY--;
                    } else if (neighbors[dir] == 'l') {//go left
                        mazeX -= 2;
                        wallX--;
                    } else if (neighbors[dir] == 'd') {//go DOWN
                        mazeY += 2;
                        wallY++;
                    }
                }
            } else if (isEdge == TL_CORNER) {//upper left corner
                if (maze[mazeY][mazeX + 2] == WALL)
                    neighbors[neighborCount++] = 'r';
                if (maze[mazeY + 2][mazeX] == WALL)
                    neighbors[neighborCount++] = 'd';

                if (neighborCount != 0) {
                    dir = rand.nextInt(neighborCount);

                    if (neighbors[dir] == 'd') {//go DOWN
                        mazeY += 2;
                        wallY++;
                    } else {//go RIGHT
                        mazeX += 2;
                        wallX++;
                    }
                }
            } else if (isEdge == BL_CORNER) {//lower left corner
                if (maze[mazeY][mazeX + 2] == WALL)
                    neighbors[neighborCount++] = 'r';
                if (maze[mazeY - 2][mazeX] == WALL)
                    neighbors[neighborCount++] = 'u';

                if (neighborCount != 0) {
                    dir = rand.nextInt(neighborCount);

                    if (neighbors[dir] == 'u') {//go UP
                        mazeY -= 2;
                        wallY--;
                    } else {//go RIGHT
                        mazeX += 2;
                        wallX++;
                    }
                }
            } else if (isEdge == TR_CORNER) {//upper RIGHT corner
                if (maze[mazeY + 2][mazeX] == WALL)
                    neighbors[neighborCount++] = 'd';
                if (maze[mazeY][mazeX - 2] == WALL)
                    neighbors[neighborCount++] = 'l';

                if (neighborCount != 0) {
                    dir = rand.nextInt(neighborCount);

                    if (neighbors[dir] == 'l') {//go left
                        mazeX -= 2;
                        wallX--;
                    } else {//go DOWN
                        mazeY += 2;
                        wallY++;
                    }
                }
            } else if (isEdge == BR_CORNER) {//lower RIGHT corner
                if (maze[mazeY - 2][mazeX] == WALL)
                    neighbors[neighborCount++] = 'u';
                if (maze[mazeY][mazeX - 2] == WALL)
                    neighbors[neighborCount++] = 'l';

                if (neighborCount != 0) {
                    dir = rand.nextInt(neighborCount);

                    if (neighbors[dir] == 'u') {//go UP
                        mazeY -= 2;
                        wallY--;
                    } else {//go left
                        mazeX -= 2;
                        wallX--;
                    }
                }
            }

            if (neighborCount != 0) {//when we moved to a neighbor that is not visited
                maze[mazeY][mazeX] = NOT_WALL;
                maze[wallY][wallX] = NOT_WALL;//make wall between the two a space
                stack[sp++] = new Point(mazeX, mazeY);
            } else {//when there is no neighbors left to move
                mazeX = stack[--sp].x;
                mazeY = stack[sp].y;
            }
        }
    }

    public int[][] getMaze() {
        return maze;
    }

    public void setSide(int side){
        this.side = side;

    }

    public String[][] mazeToStringArray() {
        String[][] mazeASCII = new String[side * 2 + 1][side * 2 + 1];
        int mazeX, mazeY, place;

        for (int y = 0; y < mazeASCII.length; y++) {
            for (int x = 0; x < mazeASCII[y].length; x++) {
                //make the boundary walls
                if (y == 0 && x == 0)
                    mazeASCII[y][x] = " ╔";
                else if (y == 0 && x == mazeASCII[y].length - 1)
                    mazeASCII[y][x] = "╗ ";
                else if (y == mazeASCII.length - 1 && x == 0)
                    mazeASCII[y][x] = " ╚";
                else if (y == mazeASCII.length - 1 && x == mazeASCII[y].length - 1)
                    mazeASCII[y][x] = "╝ ";
                else if (x == 0 && y == 1)
                    mazeASCII[y][x] = "  ";
                else if (x == mazeASCII.length - 1 && y == mazeASCII.length - 2)
                    mazeASCII[y][x] = "  ";
                else if (y == 0)
                    mazeASCII[y][x] = "══";
                else if (x == 0)
                    mazeASCII[y][x] = " ║";
                else if (y == mazeASCII.length - 1)
                    mazeASCII[y][x] = "══";
                else if (x == mazeASCII.length - 1)
                    mazeASCII[y][x] = "║ ";

                //make the corresponding spaces in the maze
                if ((y > 0 && y < mazeASCII.length - 1) && (x > 0 && x < mazeASCII.length - 1)) {
                    mazeY = y - 1;
                    mazeX = x - 1;
                    place = maze[mazeY][mazeX];

                    if (mazeX == 0 && mazeY == 0)
                        mazeASCII[y][x] = "S ";// make starting point
                    else if (mazeX == maze.length - 1 && mazeY == maze.length - 1)
                        mazeASCII[y][x] = " D"; //make destination point
                    else if (place == NOT_WALL)
                        mazeASCII[y][x] = "  ";// make the empty spaces in the maze
                    else if (place == WALL) {//make the walls
                        mazeASCII[y][x] = "##";
                    }

                }

            }
        }
        return mazeASCII;
    }

    public void clear() {
        maze = new int[side * 2 - 1][side * 2 - 1];
    }
}