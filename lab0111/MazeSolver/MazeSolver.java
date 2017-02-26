package lab0111.MazeSolver;

import java.util.ArrayList;
import java.awt.Point;

/**
 * Created by David on 3/3/2016.
 */
public class MazeSolver {
    int[][] maze;
    private int stepsFromOrigin = 0;
    private ArrayList<Point> neighbors = new ArrayList();

    public MazeSolver(int[][] maze) {
        this.maze = maze;
    }

    private void solve(int x, int y) {
        if (x == 0) {//left edge
            if (y == 0) {//top left corner
                if (maze[y + 1][x] == 0) {
                    maze[y + 1][x] = stepsFromOrigin;
                    neighbors.add(new Point(x, y + 1));
                }
                if (maze[y][x + 1] == 0) {
                    maze[y][x + 1] = stepsFromOrigin;
                    neighbors.add(new Point(x + 1, y));
                }
            } else if (y == maze.length - 1) {//bottom left edge
                if (maze[y - 1][x] == 0) {
                    maze[y - 1][x] = stepsFromOrigin;
                    neighbors.add(new Point(x, y - 1));
                }
                if (maze[y][x + 1] == 0) {
                    maze[y][x + 1] = stepsFromOrigin;
                    neighbors.add(new Point(x + 1, y));
                }
            } else {//left edge
                if (y != 1) {//if it is not next to 0,0
                    if (maze[y - 1][x] == 0) {
                        maze[y - 1][x] = stepsFromOrigin;
                        neighbors.add(new Point(x, y - 1));
                    }
                }
                if (maze[y + 1][x] == 0) {
                    maze[y + 1][x] = stepsFromOrigin;
                    neighbors.add(new Point(x, y + 1));
                }
                if (maze[y][x + 1] == 0) {
                    maze[y][x + 1] = stepsFromOrigin;
                    neighbors.add(new Point(x + 1, y));
                }
            }
        } else if (x == maze.length - 1) {//RIGHT edge
            if (y == 0) {//top RIGHT corner
                if (maze[y + 1][x] == 0) {
                    maze[y + 1][x] = stepsFromOrigin;
                    neighbors.add(new Point(x, y + 1));
                }
            } else if (y == maze.length - 1) {//bottom RIGHT edge
                if (maze[y - 1][x] == 0) {
                    maze[y - 1][x] = stepsFromOrigin;
                    neighbors.add(new Point(x, y - 1));
                }
            } else {
                if (maze[y - 1][x] == 0) {
                    maze[y - 1][x] = stepsFromOrigin;
                    neighbors.add(new Point(x, y - 1));
                }
                if (maze[y + 1][x] == 0) {
                    maze[y + 1][x] = stepsFromOrigin;
                    neighbors.add(new Point(x, y + 1));
                }
            }
            if (maze[y][x - 1] == 0) {
                maze[y][x - 1] = stepsFromOrigin;
                neighbors.add(new Point(x - 1, y));
            }
        } else if (y == 0) {//top edge excluding corner
            if (x != 1) {//if it is not next to 0,0
                if (maze[y][x - 1] == 0) {
                    maze[y][x - 1] = stepsFromOrigin;
                    neighbors.add(new Point(x - 1, y));
                }
            }
            if (maze[y][x + 1] == 0) {
                maze[y][x + 1] = stepsFromOrigin;
                neighbors.add(new Point(x + 1, y));
            }
            if (maze[y + 1][x] == 0) {
                maze[y + 1][x] = stepsFromOrigin;
                neighbors.add(new Point(x, y + 1));
            }
        } else if (y == maze.length - 1) {//bottom edge excluding corners
            if (maze[y][x + 1] == 0) {
                maze[y][x + 1] = stepsFromOrigin;
                neighbors.add(new Point(x + 1, y));
            }
            if (maze[y][x - 1] == 0) {
                maze[y][x - 1] = stepsFromOrigin;
                neighbors.add(new Point(x - 1, y));
            }
            if (maze[y - 1][x] == 0) {
                maze[y - 1][x] = stepsFromOrigin;
                neighbors.add(new Point(x, y - 1));
            }
        } else {//not edge
            if (maze[y][x + 1] == 0) {//right
                maze[y][x + 1] = stepsFromOrigin;
                neighbors.add(new Point(x + 1, y));
            }
            if (maze[y][x - 1] == 0) {//left
                maze[y][x - 1] = stepsFromOrigin;
                neighbors.add(new Point(x - 1, y));
            }
            if (maze[y - 1][x] == 0) {//up
                maze[y - 1][x] = stepsFromOrigin;
                neighbors.add(new Point(x, y - 1));
            }
            if (maze[y + 1][x] == 0) {//down
                maze[y + 1][x] = stepsFromOrigin;
                neighbors.add(new Point(x, y + 1));
            }
        }
    }

    public char[] solveMaze() {
        int x = 0;
        int y = 0;
        boolean isEnd = false;
        ArrayList<Point> currentPoints = new ArrayList<Point>();

        stepsFromOrigin++;
        solve(x, y);

        while (!isEnd) {
            stepsFromOrigin++;
            currentPoints = new ArrayList(neighbors.size());
            for (Point p : neighbors) {
                currentPoints.add((Point) p.clone());
            }
            neighbors.clear();
            for (int i = 0; i < currentPoints.size(); i++) {
                x = currentPoints.get(i).x;
                y = currentPoints.get(i).y;
                if (x == maze.length - 1 && y == maze.length - 1) {
                    solve(x, y);
                    isEnd = true;
                    break;
                }
                solve(x, y);
            }
        }

        currentPoints.clear();
        neighbors.clear();

        ArrayList<Point> visited = new ArrayList<Point>();
        char[] directions = new char[stepsFromOrigin];

        x = maze.length - 1;//setting it to the destination
        y = maze.length - 1;

        for (int i = stepsFromOrigin - 2; i >= 0; i--) {
            if (x == 0) {//left edge
                if (y == maze.length - 1) {//bottom left corner
                    if (maze[y][x + 1] == i && !visited.contains(new Point(x + 1, y))) {
                        x++;
                        directions[i] = 'l';
                    } else if (maze[y - 1][x] == i && !visited.contains(new Point(x, y - 1))) {
                        y--;
                        directions[i] = 'd';
                    }
                } else {//left edge
                    if (maze[y][x + 1] == i && !visited.contains(new Point(x + 1, y))) {
                        x++;
                        directions[i] = 'l';
                    } else if (maze[y + 1][x] == i && !visited.contains(new Point(x, y + 1))) {
                        y++;
                        directions[i] = 'u';
                    } else if (maze[y - 1][x] == i && !visited.contains(new Point(x, y - 1))) {
                        y--;
                        directions[i] = 'd';
                    }
                }
            } else if (x == maze.length - 1) {//RIGHT edge
                if (y == 0) {//top RIGHT corner
                    if (maze[y][x - 1] == i && !visited.contains(new Point(x - 1, y))) {
                        x--;
                        directions[i] = 'r';
                    } else if (maze[y + 1][x] == i && !visited.contains(new Point(x, y + 1))) {
                        y++;
                        directions[i] = 'u';
                    }
                } else if (y == maze.length - 1) {//bottom RIGHT corner
                    if (maze[y][x - 1] == i && !visited.contains(new Point(x - 1, y))) {
                        x--;
                        directions[i] = 'r';
                    } else if (maze[y - 1][x] == i && !visited.contains(new Point(x, y - 1))) {
                        y--;
                        directions[i] = 'd';
                    }
                } else {//RIGHT edge
                    if (maze[y][x - 1] == i && !visited.contains(new Point(x - 1, y))) {
                        x--;
                        directions[i] = 'r';
                    } else if (maze[y + 1][x] == i && !visited.contains(new Point(x, y + 1))) {
                        y++;
                        directions[i] = 'u';
                    } else if (maze[y - 1][x] == i && !visited.contains(new Point(x, y - 1))) {
                        y--;
                        directions[i] = 'd';
                    }
                }
            } else if (y == 0) {//top edge excluding corner
                if (maze[y][x + 1] == i && !visited.contains(new Point(x + 1, y))) {
                    x++;
                    directions[i] = 'l';
                } else if (maze[y][x - 1] == i && !visited.contains(new Point(x - 1, y))) {
                    x--;
                    directions[i] = 'r';
                } else if (maze[y + 1][x] == i && !visited.contains(new Point(x, y + 1))) {
                    y++;
                    directions[i] = 'u';
                }
            } else if (y == maze.length - 1) {//bottom edge excluding corners
                if (maze[y][x - 1] == i && !visited.contains(new Point(x - 1, y))) {
                    x--;
                    directions[i] = 'r';
                } else if (maze[y - 1][x] == i && !visited.contains(new Point(x, y - 1))) {
                    y--;
                    directions[i] = 'd';
                } else if (maze[y][x + 1] == i && !visited.contains(new Point(x + 1, y))) {
                    x++;
                    directions[i] = 'l';
                }
            } else {//not edge
                if (maze[y][x + 1] == i && !visited.contains(new Point(x + 1, y))) {
                    x++;
                    directions[i] = 'l';
                } else if (maze[y][x - 1] == i && !visited.contains(new Point(x - 1, y))) {
                    x--;
                    directions[i] = 'r';
                } else if (maze[y - 1][x] == i && !visited.contains(new Point(x, y - 1))) {

                    y--;
                    directions[i] = 'd';
                } else if (maze[y + 1][x] == i && !visited.contains(new Point(x, y + 1))) {

                    y++;
                    directions[i] = 'u';
                }
            }
            if (x != maze.length - 1 && y != maze.length - 1) {
                visited.add(new Point(x, y));
            }
        }

        return directions;
    }
}