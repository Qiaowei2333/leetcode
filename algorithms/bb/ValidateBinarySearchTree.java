// lint 95 div and conq  use MinNode and MaxNode rather than minValue maxValue. Avoid 'root.val = Integer.MAX_VALUE not pass'
import java.util.*;
public class ValidateBinarySearchTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }

    static class TreeState {
        TreeNode minNode;
        TreeNode maxNode;
        boolean isBst;
        public TreeState(boolean isBst) {
            this.minNode = null;
            this.maxNode = null;
            this.isBst = isBst;
        }
    }

    public boolean isValidBST(TreeNode root) {
        TreeState result = validateHelper(root);
        return result.isBst;
    }

    private TreeState validateHelper(TreeNode root) {
        if (root == null) {
            return new TreeState(true);
        }

        TreeState left = validateHelper(root.left);

        TreeState right = validateHelper(root.right);

        if (!right.isBst || !left.isBst) {
            return new TreeState(false);
        }

        if (left.maxNode != null && left.maxNode.val >= root.val) { // if root.left != null, then left.maxNode != null, so we can replace left.maxNode != null with
                                                                    // root.left != null
            return new TreeState(false);
        }

        if (right.minNode != null && right.minNode.val <= root.val) {
            return new TreeState(false);
        }

        TreeState result = new TreeState(true);
        result.minNode = root.left == null ? root : left.minNode;
        result.maxNode = root.right == null ? root : right.maxNode;
        return result;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(1);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(3);
        TreeNode root5 = new TreeNode(5);
        root1.left = root2;
        root1.right = root3;
        root3.left = root4;
        root3.right = root5;


        ValidateBinarySearchTree s = new ValidateBinarySearchTree();
        boolean result = s.isValidBST(root1);
        System.out.println(result);
    }
}