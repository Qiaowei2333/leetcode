// lc 437
import java.util.*;
public class PathSum3 {
    // 复习看这个 sol2 o(n) two sum 思路
    // https://leetcode.com/problems/path-sum-iii/discuss/91878/17-ms-O(n)-java-Prefix-sum-method
    private int res = 0;
    public int pathSumTwoSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> preSum = new HashMap<>(); // key : the prefix sum, value : how many ways get to this prefix sum
        preSum.put(0, 1);
        traverseAndGetPrefixSum(root, preSum, 0, targetSum);
        return res;
    }
    
    private void traverseAndGetPrefixSum(TreeNode root, Map<Integer, Integer> preSum, int sum, int targetSum) {
        if (root == null) return;
        
        sum += root.val;
        
        res += preSum.getOrDefault(sum - targetSum, 0);
        
        preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        traverseAndGetPrefixSum(root.left, preSum, sum, targetSum);
        traverseAndGetPrefixSum(root.right, preSum, sum, targetSum);
        preSum.put(sum, preSum.get(sum) - 1);
    }


    // sol 1
    // https://leetcode.com/problems/path-sum-iii/discuss/91889/Simple-Java-DFS
    // https://www.youtube.com/watch?v=EE8S0pAi_dM&ab_channel=AndroidBabies%E5%AE%89%E5%8D%93%E5%A4%A7%E5%AE%9D%E8%B4%9D%E4%BB%AC
    // Time: O(n^2) in worst case (no branching); O(nlogn) in best case (balanced tree).
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        int left = pathSum(root.left, sum);
        int right = pathSum(root.right, sum);
        int cur = pathSumFromRoot(root, sum);
        return cur + left + right;
    }

    // number of path sum == target, have to start from root but not necessarily end at leaf
    private int pathSumFromRoot(TreeNode root, int target) {
        if (root == null) return 0;
        int leftNum = pathSumFromRoot(root.left, target - root.val);
        int rightNum = pathSumFromRoot(root.right, target - root.val);
        int curNum = leftNum + rightNum + (root.val == target ? 1 : 0);
        return curNum;
    }
}
