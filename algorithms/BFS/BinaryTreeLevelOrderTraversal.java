// lint 69 BFS template
import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();// 先取出size， 因为每个循环queue的size都是变化的，不能直接在循环条件中用i<queue.size（）
            List<Integer> level = new ArrayList();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            res.add(level);
        }

        return res;
    }
}