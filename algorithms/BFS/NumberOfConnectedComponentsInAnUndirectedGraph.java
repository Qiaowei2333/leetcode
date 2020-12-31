// lc 323
// time and space analysis  https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/discuss/516491/Java-Union-Find-DFS-BFS-Solutions-Complexity-Explain-Clean-code
// 答案参考 https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/discuss/77651/Standard-BFS-and-DFS-Solution-JAVA
import java.util.*;
public class NumberOfConnectedComponentsInAnUndirectedGraph {
    // dfs or bfs time both are O(v + e) v: # of vertex, e: # of edges
    // space O(v + e), because we have created adjacent list to represent graph
    // for dfs, stack space is up to O(v)
    // for bfs, queue space is up to O(v)
    public int countComponents(int n, int[][] edges) {
        // define and ini undirect graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int vertex = 0; vertex < n; vertex++){
            graph.put(vertex, new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            if (!graph.containsKey(edge[0])) graph.put(edge[0], new ArrayList<>());
            if (!graph.containsKey(edge[1])) graph.put(edge[1], new ArrayList<>()); 
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int vertex = 0; vertex < n; vertex++) {
            if (!visited.contains(vertex)) {
                count++;
                //bfs(vertex, graph, visited);
                dfs(vertex, graph, visited);
            }
        }
        return count;
    }
    
    private void dfs(int vertex, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if (visited.contains(vertex)) return;
        visited.add(vertex);
        for (int neighbour : graph.get(vertex)) {
            dfs(neighbour, graph, visited);
        }
    }
    
    private void bfs(int vertex, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);
        visited.add(vertex);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int neighbour : graph.get(cur)) {
                if (!visited.contains(neighbour)) {
                    queue.offer(neighbour);
                    visited.add(neighbour);
                }
            }
        }
    }
}
