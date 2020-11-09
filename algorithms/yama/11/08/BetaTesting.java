// lc 1335 
// sol https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/discuss/490297/Java-Bottom-Up-DP
// 解释 https://www.youtube.com/watch?v=eRBpfoWujQM&ab_channel=HuaHua
// https://leetcode.com/discuss/interview-question/874984/
import java.util.*;
public class BetaTesting {
    // time O(n^2*d)  space O(n*d)
    // d[i][k]: min difficulty to schedule the first i jobs in k days
    // d[i][k] = min{dp[j][k - 1] + max(jobDiff[j+1 -> i])}  j:[k-1, i-1]   k:[1, d]  i:[1, numOfTests]
    public int minDifficulty(int[] jobDifficulty, int d) {
        int numOfTests = jobDifficulty.length;
        if (d > numOfTests) return -1;
        int[][] dp = new int[numOfTests + 1][d + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        for (int m = 1; m <= d; m++) {
            for (int i = 1; i <= numOfTests; i++) {
                int maxJob = 0;
                for (int j = i - 1; j >= m - 1; j--) {
                    maxJob = Math.max(maxJob, jobDifficulty[j]);
                    dp[i][m] = Math.min(dp[i][m], dp[j][m - 1] + maxJob);
                }
            }
        }
        return dp[numOfTests][d];
    }
    
    public static void main(String[] args) {
        // int[] tests = {30, 10, 40, 20, 50};
        // int days = 2;
        
        int[] tests = {74303, 20452, 66120, 44483, 5370, 68585};
        int days = 5;
        BetaTesting solution = new BetaTesting();
        System.out.println("min complexities are: " + solution.findMinComplexity(tests, days));
    }
}





}
