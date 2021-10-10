// ms oa, n vertexes and n edges, dfs solve it
// 注意此题不是general的有相图里面查找环，是有条件的
// 如果是general的有相图查环，可以用拓扑排序或者dfs
public class DetectCycle {
    // sol - topological sort  time - O(n + l) l - edges.length
    public boolean hasCycle(int n, int[][] edges) { // {0, 1} 0->1
        int[] indegree = new int[n];
        int[] outdegree = new int[n]; 
        for (int[] edge : edges) { // u -> v
            int u = edge[0];
            int v = edge[1];
            indegree[u]++;
            outdegree[v]++;
        }

        for (int i = 0; i < n; i++) {
            if (indegree[i] != 1 || outdegree[i] != 1)
                return false;
        }

        return true;
    }
}
