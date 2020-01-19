// lint11

import java.util.*;

public class SearchRangeInBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        List<Integer> result = new ArrayList<Integer>();
        helper(result, root, k1, k2);
        return result;
    }

    private void helper(List<Integer> result, TreeNode root, int k1, int k2) {
        if (root == null) {
            return;
        }

        if (root.val > k1) {
            helper(result, root.left, k1, k2);
        }

        if (root.val >= k1 && root.val <= k2) {
            result.add(root.val);
        }

        if (root.val < k2) {
            helper(result, root.right, k1, k2);
        }
    }
}