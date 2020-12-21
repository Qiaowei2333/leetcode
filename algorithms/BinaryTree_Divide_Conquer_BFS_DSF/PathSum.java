// lc 112
public class PathSum {
    private boolean res = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        traverse(root, 0, sum);
        return res;
    }
    
    private void traverse(TreeNode root, int curSum, int target) {
        if (root == null) return;
        if (root.left == null && root.right == null && curSum + root.val == target) {
            res = true;
            return;
        }
        traverse(root.left, curSum + root.val, target);
        traverse(root.right, curSum + root.val, target);
    }
}
