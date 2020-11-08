// https://leetcode.com/discuss/interview-question/376375/
// lc 701 && lc 235
import java.util.*;
public class DistanceBetweenNodesInBST {
    // O(h) h: height of tree 即便优化了，本质上还是search in a bst，所以time complex is still o(h)
    public int findDis(TreeNode root, int p, int q) {
        if (p > q) return findDis(root, q, p);
        
        if (root.val > q) {
            return findDis(root.left, p, q);
        }
        else if (root.val < p) {
            return findDis(root.right, p, q);
        }
        else {
            int disToP = searchNode(root, p);
            int distToQ = searchNode(root, q);
            if (disToP != -1 && distToQ != -1) {
                return disToP + distToQ;
            }
            else {
                return -1;
            }
        }
    }
    // O(h) h : height of tree
    private int searchNode(TreeNode root, int target) {
        if (root == null) return -1;
        if (root.val == target) return 0;
        else if (root.val > target) {
            int dist1 = searchNode(root.left, target);
            return dist1 == -1 ? -1 : dist1 + 1;
        }
        else {
            int dist2 = searchNode(root.right, target);
            return dist2 == -1 ? -1 : dist2 + 1;
        }
    }

    // time O(nlogn) n: length of nums,  bst with n nodes has min height O(logn)
    public TreeNode buildBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        TreeNode root = new TreeNode(nums[0]);
        for (int i = 1; i < nums.length; i++) insertIntoBST(root, nums[i]);
        return root;
    }

    // O(h) h: height of tree
    private TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        else if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
          this.val = val;
        }
    }

    public static void main(String[] args) {
        DistanceBetweenNodesInBST s = new DistanceBetweenNodesInBST();
        int[] nums = {2, 1, 3};
        TreeNode root = s.buildBST(nums);
        int dis = s.findDis(root, 0, 3);
        System.out.println(dis);
    }
}
