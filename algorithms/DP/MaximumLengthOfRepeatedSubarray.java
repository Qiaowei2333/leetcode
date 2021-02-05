// lc 718
import java.util.*;
public class MaximumLengthOfRepeatedSubarray {
    // dp[i][j] - length of longest common subarray 截止在 A[i-1]（包含）, B[j-1]（包含）
    public int findLength(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        MaximumLengthOfRepeatedSubarray s = new MaximumLengthOfRepeatedSubarray();
        int res = s.findLength(new int[]{3,2,1,4,7}, new int[]{1,2,3,2,1});
        System.out.println(res);
    }
}
