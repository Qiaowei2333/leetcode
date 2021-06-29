// lc 413 不算高频
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len == 1 || len == 2) return 0;
        int[] dp = new int[len]; // dp[i] - 到i为止的the number of arithmetic subarrays 
        int start = 0;
        int diff = nums[1] - nums[0];
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i - 1] == diff) {
                dp[i] = i - start - 1 + dp[i - 1];
            }
            else {
                start = i - 1;
                diff = nums[i] - nums[i - 1];
                dp[i] = dp[i - 1];
            }
        }
        return dp[len - 1];
    }
}
