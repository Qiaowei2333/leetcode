// lint 11, 于lc 938类似

import java.util.*;

public class SearchRangeInBST {
// Given a binary search tree and a range [k1, k2], return node values within a given range in ascending order.
// 看到return list with values in ascending order，应该明白是利用bst中序遍历   
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
    // search in bst
    // time O(h), h is the height of the tree, h could be logn if tree is balanced, or h could be n in the worst case (全在左边)
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        List<Integer> result = new ArrayList<Integer>();
        helper(result, root, k1, k2);
        return result;
    }

    private void helper(List<Integer> result, TreeNode root, int k1, int k2) {
        if (root == null) {
            return;
        }

        if (root.val > k1) { // 利用 bst 特性 pruning， root.val<=k1时没必要往左走了，左边所有数必定 < k1
            helper(result, root.left, k1, k2);
        }

        if (root.val >= k1 && root.val <= k2) {
            result.add(root.val);
        }

        if (root.val < k2) { // // 利用 bst 特性 pruning，root.val>=k2时没必要往右走了，右边所有数必定 > k2
            helper(result, root.right, k1, k2);
        }
    }

    // divide and conquer sol
    public List<Integer> searchRangeDC(TreeNode root, int k1, int k2) {
        if (root == null) return new ArrayList<Integer>();

        List<Integer> res = new ArrayList<>();

        if (root.val > k1)
            res.addAll(searchRange(root.left, k1, k2));

        if (root.val >= k1 && root.val <= k2) {
            res.add(root.val);
        }

        if (root.val < k2)
            res.addAll(searchRange(root.right, k1, k2));

        return res;
    }
}