// lc 133
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
import java.util.*;
class CloneGraph {
    // dfs
    public HashMap<Node, Node> map = new HashMap<>();
      
    public Node cloneGraph(Node node) {
        return clone(node);
    }

    public Node clone(Node node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        for (Node n : node.neighbors) {
            Node newN = clone(n);
            newNode.neighbors.add(newN);
        }
        return newNode;
    }

    // bfs
    public Node cloneGraph1(Node root) {
        if (root == null) return null;
        
        // use a queue to help BFS
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        
        // use a map to save cloned nodes
        Map<Node, Node> map = new HashMap<>();
        
        // clone the root
        map.put(root, new Node(root.val));
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
          
          // handle the neighbors
          for (Node neighbor : node.neighbors) {
            if (!map.containsKey(neighbor)) {
              // clone the neighbor
              map.put(neighbor, new Node(neighbor.val));
              // add it to the next level
              queue.add(neighbor);
            }
            
            // copy the neighbor
            map.get(node).neighbors.add(map.get(neighbor));
          }
        }
        
        return map.get(root);
    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}