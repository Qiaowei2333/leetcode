// lc 746
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n]; //dp[i] - min cost at index i, which you already pay cost[i], and are able to move to i + 1, i + 2
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
