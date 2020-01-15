//lt103 BFS
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
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        boolean rightToLeft = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new LinkedList();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (rightToLeft) {
                    level.add(0, curr.val);
                } else {
                    level.add(curr.val);
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                } 
            }
            result.add(level);
            rightToLeft = !rightToLeft;
        }
        return result;
    }
}