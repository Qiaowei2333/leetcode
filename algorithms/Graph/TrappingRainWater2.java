// lc 407 bfs + bq
import java.util.*;

public class TrappingRainWater2 {
    // Time O(mnlog(m + n))  space O(mn)
    // lc中文的解法
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length <= 2 || heightMap[0].length <= 2) return 0;
        int n = heightMap.length;
        int m = heightMap[0].length;
        
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // pq放的是放满水之后的高度
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    int id = i * m + j;
                    pq.offer(new int[]{id, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }
        
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int res = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            for (int[] dir : dirs) {
                int nx = cur[0] / m + dir[0];
                int ny = cur[0] % m + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                    if (cur[1] > heightMap[nx][ny]) {
                        res += (cur[1] - heightMap[nx][ny]);
                    }
                    visited[nx][ny] = true;
                    pq.offer(new int[]{nx * m + ny, Math.max(cur[1], heightMap[nx][ny])});
                }
            }
        }
        return res;
    }
}
