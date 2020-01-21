// lt450
import java.util.*;

public class DeleteNodeFromBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {

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
    }
}