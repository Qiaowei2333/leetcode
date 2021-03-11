// lc 746
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1]; // dp[i] - minCost at i, 最右加了一位作为结果dp[n]
        for (int i = 0; i < n; i++) {
            dp[i] = cost[i];
        }
        
        for (int j = 2; j < dp.length; j++) {
            dp[j] = Math.min(dp[j - 1], dp[j - 2]) + dp[j];
        }
        return dp[n];
    }
}
