// lc 1644 https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/discuss/926561/Java-DFS-recursion
public class LowestCommonAncestorOfABinaryTree2 {
    private int count = 0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = helper(root, p, q);
        if (count == 2) return res;
        return null;
    }
    
    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);
        
        if (root == p || root == q) {
            count++;
            return root;
        }
        
        if (left == null && right == null) {
            return null;
        }
        else if (left != null && right != null) {
            return root;
        }
        else {
            return left == null ? right : left;
        }
    }
}
