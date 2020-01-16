//lint 95
import java.util.*;

public class ValidateBinarySearchTreeTraverse {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }
    private boolean firstNode = true;// why we need this firstNode, to skip firstNode, beacuse firstNode with value = MIN_VALUE cannot satisfy 'preVal >= root.val'
    private int prevVal = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        if (!firstNode && prevVal >= root.val) {
            return false;
        }
        firstNode = false;
        prevVal = root.val;

        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
}