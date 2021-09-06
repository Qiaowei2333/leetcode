// lint88
// https://www.youtube.com/watch?v=13m9ZCB8gjw
// time O(n)
public class LowestCommonAncestorOfBinaryTree {
    static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
          this.val = val;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return searchForTargets(root, p, q);
    }
    
    
    // function meaning: search for tg1 and tg2, then return LCA of tg1 and tg2
    // if one tg is founded, 
    //    return tg, 
    // if both tgts are founded, 
    //    return root, 
    // else return null
    private TreeNode searchForTargets(TreeNode root, TreeNode tg1, TreeNode tg2) {
        if (root == null) return null;
        if (root == tg1 || root == tg2) return root;
        
        TreeNode leftRes = searchForTargets(root.left, tg1, tg2);
        TreeNode rightRes = searchForTargets(root.right, tg1, tg2);
        
        if (leftRes != null && rightRes != null) return root;
        
        return leftRes == null ? rightRes : leftRes;
    }



    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(9);
        TreeNode node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.right = node8;
        node5.left = node9;

        TreeNode node10 = new TreeNode(11);

        LowestCommonAncestorOfBinaryTree s = new LowestCommonAncestorOfBinaryTree();
        TreeNode ancestor = s.lowestCommonAncestor(node1, node2, node10);
        System.out.println(ancestor.val);
    }
}