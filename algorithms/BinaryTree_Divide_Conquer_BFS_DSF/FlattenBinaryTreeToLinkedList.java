public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        postOrder(root);
        return;
    }
    // note: return leftmost rightmost node, not min max value, this is not bst!!
    private PairMinMax postOrder(TreeNode root) {
        if (root == null) return null;
        PairMinMax leftSub = postOrder(root.left);
        PairMinMax rightSub = postOrder(root.right);
        PairMinMax cur = new PairMinMax();
        cur.min = root;
        cur.max = root;
        if (leftSub != null) {
            root.left = null;
            root.right = leftSub.min;
            cur.max = leftSub.max;
        }
        if (rightSub != null) {
            if (leftSub != null) {
                leftSub.max.right = rightSub.min;
            }
            cur.max = rightSub.max;
        }
        return cur;
    }
    
    static class PairMinMax {
        TreeNode min;
        TreeNode max;
    }
}
