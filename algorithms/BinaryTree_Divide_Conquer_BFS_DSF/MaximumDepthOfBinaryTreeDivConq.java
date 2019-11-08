public class MaximumDepthOfBinaryTreeDivConq {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(17);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        MaximumDepthOfBinaryTreeDivConq s = new MaximumDepthOfBinaryTreeDivConq();
        int result = s.maxDepth(node1);
        System.out.println(result);
    }
}