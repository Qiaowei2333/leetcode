// lc 312
// https://leetcode.com/problems/burst-balloons/discuss/76228/Share-some-analysis-and-explanations
public class BurstBalloons {
    // https://leetcode.com/problems/burst-balloons/discuss/76228/Share-some-analysis-and-explanations
    // sol2 dfs + memo, O(n^3), 复习看这个
    public int maxCoinsDFS(int[] nums) {
        int n = nums.length; 
        int[] newNums = new int[n + 2];
        int i = 1;
        for (int num : nums) {
            if (num != 0) {
                newNums[i] = num;
                i++;
            }
        }
        newNums[0] = 1;
        newNums[i++] = 1; // i is valid length of newNums, every element is not zero
        int[][] dp = new int[i][i];
        return burst(0, i - 1, newNums, dp);
    }
    
    public int burst(int start, int end, int[] nums, int[][] dp) { // burst all balloons between start to end (exclude start and end), what are the max coins
        if (end - start == 1) return 0;
        if (dp[start][end] != 0) return dp[start][end];
        int max = 0;
        for (int i = start + 1; i < end; i++) {
            max = Math.max(max, nums[start] * nums[i] * nums[end] + burst(start, i, nums, dp) + burst(i, end, nums, dp));
        }
        dp[start][end] = max;
        return max;
    }
    public int maxCoins(int[] nums) {
        // 篮子王解法
        // remove 0, add padding 1 
        int[] coins = new int[nums.length + 2];
        int n = 1;
        for (int num : nums) {
            if (num != 0) coins[n++] = num;
        }
        coins[0] = 1;
        coins[n++] = 1;
        int[][] dp = new int[n][n]; // dp[left][right]: coins obtained from bursting all the balloons between index left and right (not including left or right)
        for (int dis = 2; dis < n; dis++) { // dis is distance btw left and right, dis = right - left
            for (int left = 0; left + dis < n; left++) { 
                int right = left + dis;
                for (int i = left + 1; i < right; i++)  // i is the index last bursted between (left, right)
                    dp[left][right] = Math.max(dp[left][right], 
                    coins[left] * coins[i] * coins[right] + dp[left][i] + dp[i][right]);
            }
        }
        return dp[0][n - 1];
    }
}
