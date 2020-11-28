// lc 572
public class SubtreeOfAnotherTree {
    // time O(n*m) n is # of nodes in s, m is # of nodes in t
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isIdentical(s, t)) return true;
        if (isSubtree(s.left, t)) return true;
        if (isSubtree(s.right, t)) return true;
        return false;
    }
    
    private boolean isIdentical(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        else if (s != null && t != null) {
            if (s.val == t.val && isIdentical(s.left, t.left) && isIdentical(s.right, t.right)) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
}
