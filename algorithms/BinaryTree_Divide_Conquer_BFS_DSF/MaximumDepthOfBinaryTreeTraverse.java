// lin 97 traverse

public class MaximumDepthOfBinaryTreeTraverse {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    private int depth;

    public int maxDepth(TreeNode root) {
        depth = 0;
        traverse(root, depth + 1);
        return depth;
    }

    private void traverse(TreeNode root, int currDepth) {
        if (root == null) {
            return;
        }

        if (currDepth > depth) {
            depth = currDepth;
        }

        traverse(root.left, currDepth + 1);
        traverse(root.right, currDepth + 1);
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
        MaximumDepthOfBinaryTreeTraverse s = new MaximumDepthOfBinaryTreeTraverse();
        int result = s.maxDepth(node1);
        System.out.println(result);
    }
}