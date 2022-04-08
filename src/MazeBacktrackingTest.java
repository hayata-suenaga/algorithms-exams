import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MazeBacktrackingTest {

    @Test
    void simpleOnePath() {
        int[][] maze = {
                { 1, 0, 0, 1 },
                { 1, 0, 0, 1 },
                { 1, 1, 1, 1 }
        };

        int result = MazeBacktracking.findShortestPathLength(maze, 3, 2);
        assertEquals(5, result);
    }

    @Test
    void complicatedOnePath() {
        int[][] maze = {
                { 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 1 },
                { 1, 1, 1, 0, 1 }
        };

        int result = MazeBacktracking.findShortestPathLength(maze, 4, 3);
        assertEquals(13, result);
    }

    @Test
    void complicatedTwoPath() {
        int[][] maze = {
                { 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 1 },
                { 1, 1, 1, 1, 1 }
        };

        int result = MazeBacktracking.findShortestPathLength(maze, 4, 3);
        assertEquals(7, result);
    }

    @Test
    void shortOnePath() {
        int[][] maze = {
                { 1, 1 },
        };

        int result = MazeBacktracking.findShortestPathLength(maze, 1, 0);
        assertEquals(1, result);
    }

    @Test
    void pathLengthZero() {
        int[][] maze = {
                { 1 },
        };

        int result = MazeBacktracking.findShortestPathLength(maze, 0, 0);
        assertEquals(0, result);
    }

    @Test
    void examPrompt() {
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

        /* One possible path */
        int case1 = MazeBacktracking.findShortestPathLength(maze, 9, 9);
        assertEquals(18, case1);

        /* Two possible paths of the same length */
        int case2 = MazeBacktracking.findShortestPathLength(maze, 4, 3);
        assertEquals(7, case2);

        /* Several paths of different lengths */
        int case3 = MazeBacktracking.findShortestPathLength(maze, 7, 3);
        assertEquals(10, case3);

        /* Several paths of different lengths */
        int case4 = MazeBacktracking.findShortestPathLength(maze, 9, 0);
        assertEquals(Integer.MAX_VALUE, case4);
    }
}