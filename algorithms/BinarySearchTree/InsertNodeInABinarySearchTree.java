// lint 85
public class InsertNodeInABinarySearchTree{
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }

        if (root.val > node.val) {
            root.left = insertNode(root.left, node);
        }

        if (root.val < node.val) {
            root.right = insertNode(root.right, node);
        }

        return root;
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

        TreeNode node = new TreeNode(0);
        TreeNode result = s.insertNode(node1, node);
        System.out.println(result);
    }
}