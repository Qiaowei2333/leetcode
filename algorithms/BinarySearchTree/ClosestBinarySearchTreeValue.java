// lc 270
public class ClosestBinarySearchTreeValue {
    private double dis = Double.MAX_VALUE;
    private int res;
    // O(h), h is height of bst, ranges from logn to n
    public int closestValue(TreeNode root, double target) {
        helper(root, target);
        return res;
    }
    public void helper(TreeNode root, double target) {
        if (root == null) return;

        if ((double) root.val > target) {
            helper(root.left, target);
        }
        
        if (Math.abs((double) root.val - target) < dis) {
            res = root.val;
            dis = Math.abs((double) root.val - target);
        }

        if ((double) root.val < target) {
            helper(root.right, target);
        }
    }
}
