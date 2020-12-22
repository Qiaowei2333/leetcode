// lc 173  与 lc 94很像 iterative inoder traversal of binary tree
import java.util.*;

public class BSTIterator {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        pushAll(root);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode curr = stack.pop();
        if (curr.right != null) {
            pushAll(curr.right);
        }
        return curr.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node3 = new TreeNode(3);
        TreeNode node15 = new TreeNode(15);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        node7.left = node3;
        node7.right = node15;
        node15.left = node9;
        node15.right = node20;
        BSTIterator iterator = new BSTIterator(node7);
        while (iterator.hasNext()) {
            int val = iterator.next();
            System.out.println(val);
        }
    }
}