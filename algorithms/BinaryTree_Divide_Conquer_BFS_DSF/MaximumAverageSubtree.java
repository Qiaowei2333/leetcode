// lc 1120
public class MaximumAverageSubtree {
    private double result;
    
    public double maximumAverageSubtree(TreeNode root) {
        result = -1.0;
        helper(root);
        return result;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) return new ResultType(0, 0.0);
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        int num = left.num + right.num + 1;
        double avg = (left.num * left.avg + right.num * right.avg + root.val) / num;
        result = Math.max(result, avg);
        return new ResultType(num, avg);
    }
    
    static class ResultType {
        int num;
        double avg;
        public ResultType(int num, double avg) {
            this.num = num;
            this.avg = avg;
        }
    }
}
