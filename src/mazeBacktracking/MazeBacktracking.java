package mazeBacktracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MazeBacktracking {

    public static void main(String[] args) {
        int[][] maze = {
                { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
                { 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
                { 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
                { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                { 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 }
        };

        int goalXIdx = getIntFromCL("Goal X Index: ");
        int goalYIdx = getIntFromCL("Goal Y Index: ");

        int shortestPathLength = findShortestPathLength(maze, goalXIdx, goalYIdx);
        System.out.println("Length of the shortest path: " + shortestPathLength);
    }

    static int findShortestPathLength(int[][] maze, int goalXIdx, int goalYIdx) {
        Point goalPt = new Point(goalXIdx, goalYIdx);
        List<Point> path = new ArrayList<>();
        /* Add the start position (0, 0) to the path */
        path.add(new Point(0, 0));
        /* From the root (start position), descend the state space tree,
        backtracking each time a node is deemed not promising */
        return helper(maze, path, goalPt, Integer.MAX_VALUE);
    }

    static int helper(int[][] maze, List<Point> path, Point goalPt, int minPathLength) {

        /* If the current point is the goal, return the shorter between the current path or min path so far */
        if (path.get(path.size() - 1).equals(goalPt)) {
            return Math.min(path.size() - 1, minPathLength);
        }
        /* Check if the current position is promising or not */
        if (!isPromising(maze, path, goalPt, minPathLength)) { return minPathLength; }

        /* Get the current position */
        Point currentPt = path.get(path.size() - 1);

        /* Get positions right, left, up, down from the current one */
        Point[] points = {
                new Point(currentPt.x - 1, currentPt.y),
                new Point(currentPt.x + 1, currentPt.y),
                new Point(currentPt.x, currentPt.y - 1),
                new Point(currentPt.x, currentPt.y + 1),
        };

        /* Investigate paths extending to each four directions */
        for (Point point : points) {
            path.add(point);
            /* Get the min path of each path */
            minPathLength = Math.min(minPathLength, helper(maze, path, goalPt, minPathLength));
            path.remove(path.size() - 1);
        }

        return minPathLength;
    }

    static boolean isPromising(int[][] maze, List<Point> path, Point goalPt, int minPathLength) {
        /* Get the last selected position from the path */
        Point currentPt = path.get(path.size() - 1);
        /* If the current position is not legal, the choice is not promising */
        if (!isPositionLegal(maze, currentPt)) return false;
        /* If the path already contains the current position, the choice will not yield the shortest path */
        if (path.subList(0, path.size() - 1).contains(currentPt)) return false;
        /* If the minimal length required to get to the goal from the current position
        is greater than the current min length, the choice is not promising */
        int possibleMinLength = getMinLengthRequired(currentPt, goalPt) + path.size() - 1;
        return possibleMinLength < minPathLength;
    }

    static int getMinLengthRequired(Point pt1, Point pt2) {
        return Math.abs(pt1.x - pt2.x) + Math.abs(pt1.y - pt2.y);
    }

    static boolean isPositionLegal(int[][] maze, Point pt) {
        int mazeHeight = maze.length;
        int mazeWidth = maze[0].length;
        boolean isOutsideOfMaze = pt.x < 0 || pt.y < 0 || pt.y >= mazeHeight || pt.x >= mazeWidth;
        if (isOutsideOfMaze) return false;
        boolean isBlocking = maze[pt.y][pt.x] == 0;
        return !isBlocking;
    }

    static int getIntFromCL(String prompt) {
        /* Instantiate a scanner to read from the command line */
        Scanner scanner = new Scanner(System.in);
        /* Prompt the user */
        System.out.print(prompt);
        /* Read, parse, and return the integetr */
        return Integer.parseInt(scanner.next());
    }

    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point another)) return false;
            return x == another.x && y == another.y;
        }
    }
}
