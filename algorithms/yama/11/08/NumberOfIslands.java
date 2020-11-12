// lt 200 time complex O(row*col)
// space bfd O(min(row, col))  O(row * col)
import java.util.*;
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    // bfs(grid, i, j);
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        if (!isValid(i, j, grid)) return;
        grid[i][j] = '0';
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : dirs) {
            int r = dir[0] + i;
            int c = dir[1] + j;
            dfs(grid, r, c);
        }
    }
    
    private void bfs(char[][] grid, int i, int j) {
        Queue<Pos> queue = new LinkedList<>();
        grid[i][j] = '0';
        queue.offer(new Pos(i, j));
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            Pos curPos = queue.poll();
            for (int[] dir : dirs) {
                int r = dir[0] + curPos.row;
                int c = dir[1] + curPos.col;
                if (isValid(r, c, grid)) {
                    grid[r][c] = '0';
                    queue.offer(new Pos(r, c));
                }
            }
        }
    }
    
    private boolean isValid(int r, int c, char[][] grid) {
        if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == '1') {
           return true; 
        }
        else {
            return false;
        }
    }
    
    static class Pos {
        int row;
        int col;
        public Pos(int x, int y) {
            row = x;
            col = y;
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