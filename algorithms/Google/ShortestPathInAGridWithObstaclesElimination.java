// lc 1293
// https://www.youtube.com/watch?v=2pLhH2eLaP8&ab_channel=HuifengGuan
import java.util.*;
public class ShortestPathInAGridWithObstaclesElimination {
    private int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 1 && n == 1) return 0;
        
        boolean[][][] visited = new boolean[m][n][k + 1]; // 0 ... k
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(0, 0, 0));
        visited[0][0][0] = true;
        
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                State cur = queue.poll();
                for (int[] dir : dirs) {
                    int newX = dir[0] + cur.x;
                    int newY = dir[1] + cur.y;
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n) continue;
                    if (newX == m - 1 && newY == n - 1) return steps;
                    if (grid[newX][newY] == 1) {
                        if (cur.elmntdObs == k) continue;
                        if (!visited[newX][newY][cur.elmntdObs + 1]) {
                            visited[newX][newY][cur.elmntdObs + 1] = true;
                            queue.offer(new State(newX, newY, cur.elmntdObs + 1));
                        }
                    }
                    else {
                        if (!visited[newX][newY][cur.elmntdObs]) {
                            visited[newX][newY][cur.elmntdObs] = true;
                            queue.offer(new State(newX, newY, cur.elmntdObs));
                        }
                    }
                }
            }
        }
        return -1;
    }

    static class State {
        int x;
        int y;
        int elmntdObs;
        public State(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.elmntdObs = z;
        }
    }
}
