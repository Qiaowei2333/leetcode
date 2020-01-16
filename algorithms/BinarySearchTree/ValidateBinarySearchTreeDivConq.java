// lint 95 div and conq  cannot pass {2147483647} 
import java.util.*;
public class ValidateBinarySearchTreeDivConq {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }

    static class TreeState {
        int min;
        int max;
        boolean isBst;
        public TreeState(int min, int max, boolean isBst) {
            this.min = min;
            this.max = max;
            this.isBst = isBst;
        }
    }

    public boolean isValidBST(TreeNode root) {
        TreeState result = validateHelper(root);
        return result.isBst;
    }

    private TreeState validateHelper(TreeNode root) {
        if (root == null) {
            return new TreeState(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        TreeState left = validateHelper(root.left);

        if (!left.isBst || left.max >= root.val) {
            return new TreeState(0, 0, false);
        }

        TreeState right = validateHelper(root.right);

        if (!right.isBst || right.min <= root.val) {
            return new TreeState(0, 0, false);
        }

        return new TreeState(Math.min(left.min, root.val), Math.max(right.max, root.val), true);
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


        ValidateBinarySearchTreeDivConq s = new ValidateBinarySearchTreeDivConq();
        boolean result = s.isValidBST(root1);
        System.out.println(result);
    }
}