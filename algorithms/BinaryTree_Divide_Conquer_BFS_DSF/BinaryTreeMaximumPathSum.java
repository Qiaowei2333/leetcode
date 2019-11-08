// https://www.youtube.com/watch?v=9ZNky1wqNUw 花花酱解释
// time: O(n)   Space: O(h)  h is the height of the tree
public class BinaryTreeMaximumPathSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    private int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;   
    }

    // path with max sum, must include current node 
    private int maxPathDown(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, maxPathDown(root.left));
        int right = Math.max(0, maxPathDown(root.right));

        maxValue = Math.max(maxValue, left + right + root.val); // 把这一句去掉， 就是find a path including current node with max sum
                                                                // 这就是 maxPathDown 的含义
        return Math.max(left, right) + root.val;
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(17);
        node1.left = node2;
        node1.right = node3;
    
        BinaryTreeMaximumPathSum s = new BinaryTreeMaximumPathSum();
        int sum = s.maxPathSum(node1);

        System.out.println(sum);
    }
}