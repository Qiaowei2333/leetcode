// lt261
class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (n == 0) {
            return false;
        }
        // 节点数 - 1 = 边的数
        if (n - 1 != edges.length) {
            return false;
        }
        
        Map<Integer, Set<Integer>>graph = iniUndirectedGraph(n, edges);
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        
        queue.add(0);
        set.add(0);
        // bfs 看是否联通
        while (!queue.isEmpty()) {
            int curV = queue.poll();
            for (Integer neighbor : graph.get(curV)) {
                if (!set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        
        return set.size() == n;
    }
    
    private Map<Integer, Set<Integer>> iniUndirectedGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        
        for (int j = 0; j < edges.length; j++) {
            int u = edges[j][0];
            int v = edges[j][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        return graph;
    }
}