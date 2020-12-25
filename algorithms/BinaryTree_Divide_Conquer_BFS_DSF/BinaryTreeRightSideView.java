// lc 199
import java.util.*;
public class BinaryTreeRightSideView {
    // dfs preOrder O(n) n - # of nodes in tree
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        topDown(root, 0, res);
        return res;
    }
    
    private void topDown(TreeNode root, int depth, List<Integer> res) {
        if (root == null) {
            return;
        }
        
        if (res.size() < depth + 1) {
            res.add(root.val);
        }
        else {
            res.set(depth, root.val);
        }
        topDown(root.left, depth + 1, res);
        topDown(root.right, depth + 1, res);
    }

    // bfs - level order traversal
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        bfs(root, res);
        return res;
    }

    private void bfs(TreeNode root, List<Integer> res) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) res.add(cur.val);
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
            }
        }
    }
}
