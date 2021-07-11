// lc 45
import java.util.Arrays;

// https://www.youtube.com/watch?v=XYJ6jIlCmio
public class JumpGame2 {
    // https://leetcode.com/problems/jump-game-ii/discuss/18028/O(n)-BFS-solution
    // 将问题转化为BFS的问题来理解，比greedy好理解
    public int jump1(int[] nums) {
        if (nums.length < 2) return 0; // [0] res should be 0
        int switchPoint = 0; // 第一个switchingpoint是0，第一步必须在0跨出去
        int rightMost = 0;
        int jumps = 0;
        for (int i = 0; i < nums.length; i++) {
            rightMost = Math.max(rightMost, i + nums[i]);
            if (i == switchPoint) {
                switchPoint = rightMost;
                jumps++;
                if (rightMost >= nums.length - 1) {
                    break; // 发现下一个切换点已经超过了最后一个点了
                }
            }
        }
        return jumps;
    }

    // recursion sol  time: O(k^n) n - nums.length, k - avg steps of each nums
    public int jump2(int[] nums, int start, int end) { // jump2含义 - 从start到end跳过去的min steps
        if (start >= end) return 0;
        int res = Integer.MAX_VALUE / 2; // 假如nums=[0, 1, 4] 如果res = Integer.MAX_VALUE， return 的结果是最大整数，因为第一个是0，一步都走不了，永远到不了end，最大整数返回后加一就变成负数了
        for (int i = start + 1; i <= start + nums[start] && i <= end; i++) {
            res = Math.min(res, 1 + jump2(nums, i, end));
        }
        return res;
    }

    // recursion + memorization sol  time: O(k*n) n - nums.length, k - avg steps of each nums
    public int jump(int[] nums) {
        int[] dp = new int[nums.length]; // dp[i]表示 i 到 nums.length的 min steps
        Arrays.fill(dp, -1);
        return jump3(nums, 0, nums.length - 1, dp);
    }

    private int jump3(int[] nums, int start, int end, int[] dp) {
        if (start >= end) return 0;
        if (dp[start] != -1) return dp[start];
        int res = Integer.MAX_VALUE / 2;
        for (int i = start + 1; i <= start + nums[start] && i <= end; i++) {
            res = Math.min(res, 1 + jump3(nums, i, end, dp));
        }
        dp[start] = res;
        return res;
    }
}
