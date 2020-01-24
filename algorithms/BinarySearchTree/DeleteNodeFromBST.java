// lt450 https://www.youtube.com/watch?v=00r9qf7lgAk
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

    // change value, not node
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

    // remove node
    public TreeNode deleteNode1(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val > key) {
            root.left = deleteNode1(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode1(root.right, key);
        } else {
            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                TreeNode parent = root;
                TreeNode newRoot = root.right;
                while (newRoot.left != null) {
                    parent = newRoot;
                    newRoot = newRoot.left;
                }
                if (parent != root) {
                    parent.left = newRoot.right;
                    newRoot.right = root.right;
                }
                newRoot.left = root.left;
                root = newRoot;
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