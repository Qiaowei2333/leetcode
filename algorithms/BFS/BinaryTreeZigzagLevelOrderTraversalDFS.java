//lt103 DFS
import java.util.*;
public class BinaryTreeZigzagLevelOrderTraversalBFS {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        traverse(root, result, 0);
        return result;
    }

    private void traverse(TreeNode root, List<List<Integer>> result, int depth) {
        if (root == null) {
            return;
        }

        if (result.size() <= depth) {
            result.add(new LinkedList<Integer>());
        }

        LinkedList<Integer> level = result.get(depth); 
        if (depth % 2 == 0) {
            level.add(root.val);
        } else {
            level.add(0, root.val);
        }
        
        traverse(root.left, result, depth + 1);
        traverse(root.right, result, depth + 1);
    }
}