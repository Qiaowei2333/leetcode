// lin66
import java.util.*;
public class PreOrderTraversal {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int value) {
            this.val = value;
        }
    }

    public ArrayList<Integer> preOrderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        traverse(root, result);
        return result;
    }

    public void traverse(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        // System.out.println(root.val);
        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }

    // divide and conquer
    public ArrayList<Integer> preOrderTraversalDivConq(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }

        ArrayList<Integer> leftResult = preOrderTraversalDivConq(root.left);
        ArrayList<Integer> rightResult = preOrderTraversalDivConq(root.right);

        result.add(root.val);
        result.addAll(leftResult);
        result.addAll(rightResult);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        root.left = root2;
        root2.left = root3;
        root.right = root4;
        root4.left = root5;
        
        PreOrderTraversal s = new PreOrderTraversal();
        ArrayList<Integer> res = s.preOrderTraversal(root);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}