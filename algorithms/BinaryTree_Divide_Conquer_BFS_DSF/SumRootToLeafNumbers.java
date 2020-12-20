// lc 129
// root to leaf, traverse sol
public class SumRootToLeafNumbers {
    private int sum = 0;
    public int sumNumbers(TreeNode root) {
        traverse(root, 0);
        return sum;
    }
    
    private void traverse(TreeNode root, int curSum) {
        if (root == null) return;
        curSum = curSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += curSum;
        }
        traverse(root.left, curSum);
        traverse(root.right, curSum);
    }
}
