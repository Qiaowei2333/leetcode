// lc 312
// https://leetcode.com/problems/burst-balloons/discuss/76228/Share-some-analysis-and-explanations
public class BurstBalloons {
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
