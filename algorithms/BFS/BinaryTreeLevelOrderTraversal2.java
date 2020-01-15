// lint 70
import java.util.*;

public class BinaryTreeLevelOrderTraversal2 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new LinkedList();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            result.add(0, level);
        }
        return result;
    }
}