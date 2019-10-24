// lin93
import java.util.*;

public class BalancedBinaryTree {
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            value = x; 
        }
    }
    static class TreeState {
        int height;
        boolean isBalanced;
        public TreeState(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        TreeState ts = checkBalanced(root);
        return ts.isBalanced;
    }

    public TreeState checkBalanced(TreeNode root) {
        if (root == null) {
            return new TreeState(0, true);
        }
        
        TreeState left = checkBalanced(root.left);
        TreeState right = checkBalanced(root.right);

        if (Math.abs(left.height - right.height) <= 1 && left.isBalanced && right.isBalanced) {
            return new TreeState(Math.max(left.height, right.height) + 1, true);
        }
        else {
            return new TreeState(Math.max(left.height, right.height) + 1, false);
        }

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
        BalancedBinaryTree s = new BalancedBinaryTree();
        boolean result = s.isBalanced(null);
        System.out.println(result);  
    }
}