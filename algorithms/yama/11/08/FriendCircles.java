// lc 547
import java.util.*;
public class FriendCircles {
    // time O(n^2) space O(n) - bfs/dfs
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                bfs(M, i, visited);
                // dfs(M, i, visited);
            }
        }
        return count;
    }
    
    private void bfs(int[][] M, int i, boolean[] visited) {
        visited[i] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int stud = 0; stud < M.length; stud++) {
                if (!visited[stud] && M[cur][stud] == 1) {
                    visited[stud] = true;
                    queue.offer(stud);
                }
            }
        }
    }

    private void dfs(int[][] M, int i, boolean[] visited) {
        if (visited[i]) return;
        visited[i] = true;
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1) {
                dfs(M, j, visited);
            }    
        }
    }
}
