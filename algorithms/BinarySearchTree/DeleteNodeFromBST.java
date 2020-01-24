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
        if (root == null) {
            return null;
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left != null && root.right != null) {
                TreeNode newRoot = root.right;
                while (newRoot.left != null) {
                    newRoot = newRoot.left;
                }
                root.val = newRoot.val;
                root.right = deleteNode(root.right, root.val);
            } else {
                root = root.left == null ? root.right : root.left;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        node5.left = node3;
        node5.right = node6;
        node3.left = node2;
        node3.right = node4;
        node6.right = node7;

        DeleteNodeFromBST s = new DeleteNodeFromBST();
        TreeNode result = s.deleteNode(node5, 3);
        System.out.println(result);
    }
}