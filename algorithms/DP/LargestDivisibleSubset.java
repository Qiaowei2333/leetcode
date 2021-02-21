// lc 368 https://www.youtube.com/watch?v=hrwP6I5v1XY&ab_channel=HuifengGuan
// 借鉴lc 300 LIS
import java.util.*;
public class LargestDivisibleSubset {
    // time O(n^2)
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int[] dp = new int[nums.length];// sort后 dp[i]含义 - nums[0...i] 到i为止的Largest Divisible Subset size
        Arrays.fill(dp, 1);
        int[] pre = new int[nums.length];
        Arrays.fill(pre, -1);
        int maxIdx = -1;
        int maxSize = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIdx = i;
            }
        }
        while (maxIdx != -1) {
            res.add(nums[maxIdx]);
            maxIdx = pre[maxIdx];
        }
        return res;
    }
}
