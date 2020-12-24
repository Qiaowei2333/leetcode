// lc 700
public class SearchinABST {
    // O(h) h is height of bst, h ranges from logn to n
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        TreeNode left = null;
        TreeNode right = null;
        if (root.val > val) 
            left = searchBST(root.left, val);
        
        if (root.val == val) return root;
        
        if (root.val < val)
            right = searchBST(root.right, val);
        
        return left == null ? right : left;
    }
}
