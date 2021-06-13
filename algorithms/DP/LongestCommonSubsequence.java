
// lc 1143
import java.util.*;
// explain why dp[i + 1][j + 1] =  Math.max(dp[i][j + 1], dp[i + 1][j]);
// xxxx i
// yyy j
// case 1 if i , j both belong to the lcs, that means i == j, thus dp[i + 1][j + 1] = 1 + dp[i][j];
// case 2 if i, j both not belong to the lcs, that means dp[i + 1][j + 1] = dp[i][j]
// case 3 if i, j one belongs to the lcs, the other not, that means dp[i + 1][j + 1] = dp[i][j + 1] or dp[i + 1][j]
// Since dp[i][j] <= dp[i + k][j] or dp[i][j + k], case 2 and 3 can be merged to: dp[i + 1][j + 1] =  Math.max(dp[i][j + 1], dp[i + 1][j]);
public class LongestCommonSubsequence {
    // dp sol
    public int longestCommonSubsequenceDP(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) 
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else 
                    dp[i][j] =  Math.max(dp[i - 1][j], dp[i][j - 1]);
            }  
        }
        return dp[n][m];
    }

    // divide and conquer sol - TLE 需要加上 memorization 
    // https://leetcode.com/problems/longest-common-subsequence/discuss/559027/For-those-who-struggling-with-DP
    // time: O(m*n)  dfs + memo
    public int longestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return longestCommonSubsequenceDC(s1, s2, dp);
    }
    
    public int longestCommonSubsequenceDC(String s1, String s2, int[][] dp) {
        int n = s1.length();
        int m = s2.length();
        if (dp[n][m] != -1) return dp[n][m];

        if (n == 0 || m == 0) {
            dp[n][m] = 0;
            return 0;
        }

        String s1MnsOne = s1.substring(0, n - 1);
        String s2MnsOne = s2.substring(0, m - 1);
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            dp[n][m] = longestCommonSubsequenceDC(s1MnsOne, s2MnsOne, dp) + 1;
        } 
        else {
            dp[n][m] = Math.max(longestCommonSubsequenceDC(s1MnsOne, s2, dp), longestCommonSubsequenceDC(s1, s2MnsOne, dp));
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence s = new LongestCommonSubsequence();
        int res = s.longestCommonSubsequence("abc", "d");
        System.out.println(res);
    }
}