// lc 1676 于 lc 236一个意思，就是两个点变成了一堆点，所有点都是unique，而且都在树里
import java.util.*;
public class LowestCommonAncestorOfABinaryTreeIV {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<Integer> set = new HashSet<>();
        for(TreeNode t: nodes) set.add(t.val);
        return findLCAHelper(root, set);
    }
    
    
    private TreeNode findLCAHelper(TreeNode root, Set<Integer> set) {
        if (root == null || set.contains(root.val)) return root;
        TreeNode leftLCA = findLCAHelper(root.left, set);
        TreeNode rightLCA = findLCAHelper(root.right, set);
        if (leftLCA != null && rightLCA != null) return root;
        return leftLCA == null ? rightLCA : leftLCA;
    }
}