// lc 797 backtracing dfs
import java.util.*;
public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        if (graph.length == 0) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfsHelper(0, graph.length - 1, graph, path, result);
        return result;
    }
    
    private void dfsHelper(int cur, int target, int[][] graph, List<Integer> path, List<List<Integer>> result) {
        if (cur == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = 0; i < graph[cur].length; i++) {
            int curNode = graph[cur][i];
            path.add(curNode);
            dfsHelper(curNode, target, graph, path, result);
            path.remove(path.size() - 1);
        }
    }
}