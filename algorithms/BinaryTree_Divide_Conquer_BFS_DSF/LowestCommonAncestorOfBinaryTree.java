// lint88
public class LowestCommonAncestorOfBinaryTree {
    static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
          this.val = val;
        }
    }

    /*
     * @param root: The root of the binary search tree.
     * 
     * @param A: A TreeNode in a Binary.
     * 
     * @param B: A TreeNode in a Binary.
     * 
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
        // if (left != null && right == null) {
        //     return left;
        // }

        // if (left == null && right != null) {
        //     return right;
        // }

        // return null;
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.right = node8;
        node5.left = node9;

        LowestCommonAncestorOfBinaryTree s = new LowestCommonAncestorOfBinaryTree();
        TreeNode ancestor = s.lowestCommonAncestor(node1, node2, node9);
        System.out.println(ancestor.val);
    }
}