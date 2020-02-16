// lt 200 time complex O(row*col)
import java.util.*;
public class NumberOfIslands {
    static class Coordinate {
        int row;
        int col;
        public Coordinate(int x, int y) {
            this.row = x;
            this.col = y;
        } 
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int numOfIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    checkAndMark(i, j, grid);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }

    private void checkAndMark(int row, int col, char[][]grid) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(row, col));
        grid[row][col] = '0';
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            Coordinate curCoor = queue.poll();
            for (int i = 0; i < dirs.length; i++) {
                int[] dir = dirs[i];
                int newRow = curCoor.row + dir[0];
                int newCol = curCoor.col + dir[1];
                if (isLand(newRow, newCol, grid)) {
                    grid[newRow][newCol] = '0';
                    queue.offer(new Coordinate(newRow, newCol));
                }
            }
        }
    }

    private boolean isLand(int row, int col, char[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return false;
        } else if (grid[row][col] == '0') {
            return false;
        } else {
            return true;
        }
    }
    public static void main(String[] args) {
        char[] row0 = new char[] {'1', '1', '0', '0', '0'};
        char[] row1 = new char[] {'1', '1', '0', '0', '0'};
        char[] row2 = new char[] {'0', '0', '1', '0', '0'};
        char[] row3 = new char[] {'0', '0', '0', '1', '1'};
        char[][] grid = {row0, row1, row2, row3};

        NumberOfIslands s = new NumberOfIslands();
        int numOfIslands = s.numIslands(grid);
        System.out.println(numOfIslands);
    }
}