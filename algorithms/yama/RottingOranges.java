// leetcode 994
// time space complex O(row*col)
import java.util.*;
public class RottingOranges {
    private static class Coordinate {
        int col;
        int row;
        public Coordinate(int x, int y) {
            this.row = x;
            this.col = y;
        }
    }
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int numFOrg = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length ; j++) {
                if (grid[i][j] == 0) {
                    continue;
                } else if (grid[i][j] == 1) {
                    numFOrg++;
                } else {
                    queue.offer(new Coordinate(i, j));
                }
            }
        }

        if (numFOrg == 0) {
            return 0;
        }

        int mins = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            mins++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinate curPos = queue.poll();
                for (int j = 0; j < dirs.length; j++) {
                    int[] dir = dirs[j];
                    int newRow = curPos.row + dir[0];
                    int newCol = curPos.col + dir[1];
                    if (isFreshOrange(newRow, newCol, grid)) {
                        grid[newRow][newCol] = 2;
                        numFOrg--;
                        if (numFOrg == 0) {
                            return mins;
                        }
                        queue.offer(new Coordinate(newRow, newCol));
                    }
                }
            }
        }
        return -1;
    }

    private boolean isFreshOrange(int row, int col, int[][]grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return false;
        } else if (grid[row][col] == 1) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        int[][] grid = new int[][] {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        RottingOranges s = new RottingOranges();
        int result = s.orangesRotting(grid);
        System.out.println(result);
    }
}