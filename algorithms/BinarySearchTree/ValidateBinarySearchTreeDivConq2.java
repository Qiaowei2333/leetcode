// lint 95 div and conq  use MinNode and MaxNode rather than minValue maxValue. Avoid 'root.val = Integer.MAX_VALUE not pass'
// lc 98
import java.util.*;
public class ValidateBinarySearchTreeDivConq2 {
    // 左右子树都是bst, root.val大于左子树最大，小于右子树最小
    public boolean isValidBST(TreeNode root) {
        TreeState res = traverse(root);
        return res.isBST;
    }
    
    TreeState traverse(TreeNode root) {
        if (root == null) return new TreeState(true);
        TreeState left = traverse(root.left);
        TreeState right = traverse(root.right);
        if (!left.isBST || !right.isBST) {
            return new TreeState(false);
        }
        
        if ((root.left != null) && (left.maxNode.val >= root.val)) {
            return new TreeState(false);
        }
        
        if ((root.right != null) && (right.minNode.val <= root.val)) {
            return new TreeState(false);
        }
        TreeNode curMin = root.left == null ? root : left.minNode;
        TreeNode curMax = root.right == null ? root : right.maxNode;
        return new TreeState(true, curMin, curMax);
    }

    static class TreeState {
        boolean isBST;
        TreeNode maxNode;
        TreeNode minNode;
        public TreeState(boolean isBST) {
            this.isBST = isBST;
        }
        public TreeState(boolean isBST, TreeNode minNode, TreeNode maxNode) {
            this.isBST = isBST;
            this.minNode = minNode;
            this.maxNode = maxNode;
        }       
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
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


        ValidateBinarySearchTreeDivConq2 s = new ValidateBinarySearchTreeDivConq2();
        boolean result = s.isValidBST(root1);
        System.out.println(result);
    }
}