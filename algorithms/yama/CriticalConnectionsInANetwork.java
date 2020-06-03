// lc 1192
import java.util.*;
public class CriticalConnectionsInANetwork {
    // tarjan algo to find cycle  O(v + e)
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int j = 0; j < n; j++) {
            map.put(j, new ArrayList<>());
        }

        for (int i = 0; i < connections.size(); i++) {
            List<Integer> c = connections.get(i);
            int a = c.get(0);
            int b = c.get(1);
            map.get(a).add(b);
            map.get(b).add(a);
        }
        int[] discTime = new int[n];
        Arrays.fill(discTime, -1);
        int[] lowest = new int[n];
        dfsHelper(map, result, -1, 0, 0, discTime, lowest);

        return result;
    }

    private int dfsHelper(Map<Integer, List<Integer>> map, List<List<Integer>> result, int preStart, int start, int timer, int[] discTime, int[] lowest) {
        if (discTime[start] != -1) {
            return lowest[start];
        }

        discTime[start] = timer;
        lowest[start] = timer;
        timer++;

        for (Integer i : map.get(start)) {
            if (i == preStart) {
                continue;
            }
            int returnedLowest = dfsHelper(map, result, start, i, timer, discTime, lowest);
            if (returnedLowest > discTime[start]) {
                result.add(Arrays.asList(start, i));
            }
            else {
                lowest[start] = Math.min(returnedLowest, lowest[start]);
            }
        }

        return lowest[start];
    }

    // brute force O(v + e) * e
    // public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    //     List<List<Integer>> result = new ArrayList<>();
    //     for (int i = 0; i < n; i++) {
    //         Set<Integer> path = new HashSet<>();
    //         List<Integer>[] graph = buildGraph(connections, n, i);
    //         int start = connections.get(i).get(1);
    //         dfs(graph, path, start);
    //         if (path.size() != n) {
    //             result.add(connections.get(i));
    //         }  
    //     }
    //     return result;
    // }

    // private void dfs(List<Integer>[] graph, Set<Integer> path, int start) {
    //     path.add(start);
    //     for (Integer i : graph[start]) {
    //         if (!path.contains(i)) {
    //             dfs(graph, path, i);
    //         }
    //     }
    //     return;
    // }

    // private List<Integer>[] buildGraph(List<List<Integer>> connections, int n, int skip) {
    //     List<Integer>[] graph = new ArrayList[n];
    //     for (int j = 0; j < n; j++) {
    //         graph[j] = new ArrayList<>();
    //     }

    //     for (int i = 0; i < connections.size(); i++) {
    //         if (i == skip) {
    //             continue;
    //         }
    //         List<Integer> c = connections.get(i);
    //         int a = c.get(0);
    //         int b = c.get(1);
    //         graph[a].add(b);
    //         graph[b].add(a);
    //     }

    //     return graph;
    // }

    public static void main(String[] args) {
        CriticalConnectionsInANetwork s = new CriticalConnectionsInANetwork();
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(1, 0));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(3, 0));
        connections.add(Arrays.asList(4, 1));
        connections.add(Arrays.asList(5, 3));
        // connections.add(Arrays.asList(3, 4));
        // connections.add(Arrays.asList(4, 5));
        // connections.add(Arrays.asList(5, 3));
        List<List<Integer>> result = s.criticalConnections(10, connections);
        System.out.println(result);
    }
}

