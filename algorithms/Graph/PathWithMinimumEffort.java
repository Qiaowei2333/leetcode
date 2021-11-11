// lc 1631
// 无向图，有权值，权值>=0
import java.util.*;
public class PathWithMinimumEffort {
    // O(eloge) e - number of edges = (n - 1) * m + (m - 1) * n, n,m stand for rows and cols
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n * m; i++) {
            graph.add(new ArrayList<>());
        }
        
        int[][] dirs = {{1, 0}, {0, 1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x >= 0 && x < n && y >= 0 && y < m) {
                        int oldIdx = i * m + j;
                        int newIdx = x * m + y;
                        int diff = Math.abs(heights[i][j] - heights[x][y]);
                        graph.get(oldIdx).add(new int[]{newIdx, diff});
                        graph.get(newIdx).add(new int[]{oldIdx, diff});
                    }
                }
            }
        }
        
        return dijkstra(0, graph);
    }
    
    private int dijkstra(int start, List<List<int[]>> graph) {// find min effort from start to last element
        int[] effortToStart = new int[graph.size()];
        Arrays.fill(effortToStart, Integer.MAX_VALUE);
        effortToStart[start] = 0;
        Queue<State> pq = new PriorityQueue<>((a, b) -> a.effortToStart - b.effortToStart);
        pq.offer(new State(start, 0));
        
        while (!pq.isEmpty()) {
            State cur = pq.poll();
            if (effortToStart[cur.id] < cur.effortToStart) {
                continue;
            }
            
            if (cur.id == graph.size() - 1) {
                return cur.effortToStart;
            }
            
            List<int[]> nbs = graph.get(cur.id);
            for (int[] nb : nbs) {
                int newId = nb[0];
                int diff = nb[1];
                int newDiff = Math.max(effortToStart[cur.id], diff);
                if (effortToStart[newId] > newDiff) {
                    effortToStart[newId] = newDiff;
                    pq.offer(new State(newId, newDiff));
                }
            }
        }
        
        return Integer.MAX_VALUE;
    }

    static class State {
        int id;
        int effortToStart;
        public State(int id, int effortToStart) {
            this.id = id;
            this.effortToStart = effortToStart;
        }
    }
}
