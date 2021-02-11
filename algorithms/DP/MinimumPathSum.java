// lc 64
public class MinimumPathSum {
    // dp[i][j] 含义： 起点(1, 1)到(i, j)位置的minimum path sum
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 || j == 1) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + grid[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i - 1][j - 1];  
                }
            }
        }
        return dp[n][m];
    }
}
