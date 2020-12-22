// lc 285
public class InorderSuccessorInBST {
    // SOL 1 inorder traversal O(n)
    private TreeNode prev;
    private TreeNode res;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        traverse(root, p);
        return res;
    }

    private void traverse(TreeNode root, TreeNode p) {
        if (root == null || res != null) return;
        traverse(root.left, p);
        if (prev == p && res == null) {
            res = root;
        }
        prev = root;
        traverse(root.right, p);
    }

    // sol 2 O(h) h is logN, height of the tree
    //To find a successor, you just need to find the smallest one that is larger than the given value since there are no duplicate values in a BST.
    //https://leetcode.com/problems/inorder-successor-in-bst/discuss/72656/JavaPython-solution-O(h)-time-and-O(1)-space-iterative
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while (root != null) {
            if (root.val > p.val) {
                succ = root;
                root = root.left;
            }
            else if (root.val < p.val) {
                root = root.right;
            } 
            else if (root.val == p.val) {
                root = root.right;
            }
        }
        return succ;
    }
}
