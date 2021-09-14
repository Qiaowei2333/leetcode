// lc 863
import java.util.*;
public class AllNodesDistanceKInBinaryTree {
    // time O(n)  space O(n) n - # of nodes in tree, each node has 3 edges at most, left, right, parent
    // build the graph, bfs traverse the graph and get all nodes at level k
    // two ways to build the graph, dfs, bfs
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        constructGraph(root, graph);
        List<Integer> res = new ArrayList<>();
        bfsTraverse(graph, res, target, K);
        return res;
    }
    
    private void bfsTraverse(Map<TreeNode, List<TreeNode>> graph, List<Integer> res, TreeNode target, int K) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> set = new HashSet<>();
        queue.offer(target);
        set.add(target);
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (dist == K) res.add(cur.val);
                for (TreeNode nb : graph.get(cur)) {
                    if (!set.contains(nb)) {
                        set.add(nb);
                        queue.offer(nb);
                    }
                }
            }
            dist++;
        }
    }
    
    private void constructGraph(TreeNode root, Map<TreeNode, List<TreeNode>> graph) {
        if (root == null) {
            return;
        }
        constructGraph(root.left, graph);
        constructGraph(root.right, graph);
        if (!graph.containsKey(root)) {
            graph.put(root, new ArrayList<>());
        }
        if (root.left != null) {
            graph.get(root).add(root.left);
            graph.get(root.left).add(root);
        }
        if (root.right != null) {
            graph.get(root).add(root.right);
            graph.get(root.right).add(root);
        }
    }

    private void constructGraphBFS(TreeNode root, Map<TreeNode, List<TreeNode>> map) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        map.put(root, new ArrayList<>());
        
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                map.put(cur.left, new ArrayList<>());
                map.get(cur).add(cur.left);
                map.get(cur.left).add(cur);
                queue.offer(cur.left);
            }
            
            if (cur.right != null) {
                map.put(cur.right, new ArrayList<>());
                map.get(cur).add(cur.right);
                map.get(cur.right).add(cur);
                queue.offer(cur.right);
            } 
        }
    }
}
