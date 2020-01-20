// lint66   stack no-recursion
import java.util.*;

public class PreOrderTraversalStack {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int value) {
            this.val = value;
        }
    }

    public ArrayList<Integer> preOrderTraversal(TreeNode root) {
        ArrayList<Integer> preOrderResult = new ArrayList<Integer>();
        if (root == null) {
            return preOrderResult;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            preOrderResult.add(curr.val);
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }

        return preOrderResult;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        root.left = root2;
        root2.left = root3;
        root.right = root4;
        root4.left = root5;
        
        PreOrderTraversalStack s = new PreOrderTraversalStack();
        ArrayList<Integer> res = s.preOrderTraversal(root);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}