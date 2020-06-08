// lc 560
import java.util.*;
public class SubarraySumEqualsK {
    // dp preSum + HashMap   t O(n)  s O(n)
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(sum, 1);
        for (int num : nums) {
            sum += num;
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return result;
    }

    // brute force time t O(n^2)  s O(1)
    public int subarraySum1(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    result++;
                }
            }
        }
        return result;
    }
}