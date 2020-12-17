//lc 144
import java.util.*;
public class BinaryTreePreorderTraversal {
    // iteration sol, use stack
    public List<Integer> preorderTraversalIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        if (root != null) st.push(root);
        
        while (!st.isEmpty()) {
            TreeNode cur = st.pop();
            res.add(cur.val);
            if (cur.right != null) st.push(cur.right);
            if (cur.left != null) st.push(cur.left);
        }
        return res;
    }

    // recursion sol
    public List<Integer> preorderTraversalRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }
    
    private void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}