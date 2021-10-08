// lc 695 与 lc 200 number of island 类似
import java.util.*;

public class MaxAreaofIsland { 
    private int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, bfs(grid, i, j));
                }
            }
        }
        
        return max;
    }
    
    private int bfs(int[][] grid, int row, int col) { // bfs traverse and return how many coordinates are traversed
        int area = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        grid[row][col] = 0;
        queue.offer(new Coordinate(row, col));
        
        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();
            area++;
            for (int[] dir : dirs) {
                int newRow = dir[0] + cur.row;
                int newCol = dir[1] + cur.col;
                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1) {
                    grid[newRow][newCol] = 0;
                    queue.offer(new Coordinate(newRow, newCol));
                }
            }
        }
        
        return area;
    }
    
	class Coordinate {
		int row;
		int col;
		public Coordinate(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
