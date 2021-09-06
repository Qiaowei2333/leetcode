// lc 1650 此题和lca关系不大，更多是想到用set来记录target到根的路线经过的节点
// time - O(height of tree) = O(logn)
import java.util.*;
public class LowestCommonAncestorOfABinaryTreeIII {
    private Node res = null;
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Integer> set = new HashSet<>();
        goUp(p, set);
        goUp(q, set);
        return res;
    }
    
    private void goUp(Node node, Set<Integer> set) {
        if (node == null) return;
        if (set.contains(node.val)) {
            res = node;
            return;
        }
        set.add(node.val);
        goUp(node.parent, set);
    }

    static class Node {
        int val;
        Node left;
        Node right;
        Node parent;
        public Node(int x) { val = x; }
    }
}
