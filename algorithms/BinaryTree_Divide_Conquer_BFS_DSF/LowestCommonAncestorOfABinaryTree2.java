// lc 1644 https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/discuss/926561/Java-DFS-recursion
public class LowestCommonAncestorOfABinaryTree2 {
    private int count = 0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = searchAllNodesForTargets(root, p, q);
        if (count == 2) return res;
        return null;
    }
    
    // traverse all nodes to find targets
    // 此题和lc 236最大不同就是不保证两个target都在树内，
    // 所以一定要遍历左右两个子树之后再判断当前根节点，这样才能遍历整个树的所有节点
    private TreeNode searchAllNodesForTargets(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        TreeNode left = searchAllNodesForTargets(root.left, p, q);
        TreeNode right = searchAllNodesForTargets(root.right, p, q);
        
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
