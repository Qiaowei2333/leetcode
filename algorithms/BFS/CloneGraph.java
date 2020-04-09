// lt 133
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
class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode root) {
        if (root == null) return null;
        
        // use a queue to help BFS
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(root);
        
        // use a map to save cloned nodes
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        // clone the root
        map.put(root, new UndirectedGraphNode(root.label));
        
        while (!queue.isEmpty()) {
          UndirectedGraphNode node = queue.poll();
          
          // handle the neighbors
          for (UndirectedGraphNode neighbor : node.neighbors) {
            if (!map.containsKey(neighbor)) {
              // clone the neighbor
              map.put(neighbor, new UndirectedGraphNode(neighbor.label));
              // add it to the next level
              queue.add(neighbor);
            }
            
            // copy the neighbor
            map.get(node).neighbors.add(map.get(neighbor));
          }
        }
        
        return map.get(root);
    }
}