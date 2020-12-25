// lc 701
public class InsertNodeInABinarySearchTree{
    // O(h) recursion sol1
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        
        if (root.val > val) {
            TreeNode left = insertIntoBST(root.left, val);
            if (root.left == null) root.left = left;
        }
        
        if (root.val < val) {
            TreeNode right = insertIntoBST(root.right, val);
            if (root.right == null) root.right = right; 
        }
        
        return root;
    }
    // O(h) iteration sol 2
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode res = root;
        TreeNode prev = null;
        while (root != null) {
            if (root.val > val) {
                prev = root;
                root = root.left; 
                if (root == null)
                    prev.left = new TreeNode(val);
            }
            else {
                prev = root;
                root = root.right;
                if (root == null)
                    prev.right = new TreeNode(val);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        InsertNodeInABinarySearchTree s = new InsertNodeInABinarySearchTree();
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(13);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        TreeNode result = s.insertIntoBST(node1, 0);
        System.out.println(result);
    }
}