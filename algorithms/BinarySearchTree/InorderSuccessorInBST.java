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
}
