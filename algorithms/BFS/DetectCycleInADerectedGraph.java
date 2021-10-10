// 类似 lc 207
import java.util.*;
// general的给了你结点0,1,2---,n-1, edges {0, 1}, {1, 2}...  0 -> 1 -> 2
public class DetectCycleInADerectedGraph {
    public boolean checkCycleInDGraph(int n, int[] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(0, new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;
            for (int nb : graph.get(cur)) {
                indegree[nb]--;
                if (indegree[nb] == 0) {
                    queue.offer(nb);
                }
            }
        }

        return count != n; // 相等证明没有环，有拓扑序列，不等证明有环
    }
}