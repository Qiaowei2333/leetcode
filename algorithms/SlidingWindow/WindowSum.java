// lint 604 https://www.lintcode.com/problem/window-sum/description
// https://www.jiuzhang.com/solution/window-sum/
public class WindowSum {
    // two pointers
    public int[] winSum(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        result[0] = sum;
        int left = 0, right = k;
        while (right < nums.length) {
            sum = sum + nums[right] - nums[left];
            result[right - k + 1] = sum;
            right++;
            left++;
        }
        return result;
    }

    // prefix sum
    public int[] winSum1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for (int i = 0; i < result.length; i++) {
            if (i == 0) {
                result[i] = prefixSum[i + k - 1];
                continue;
            }
            result[i] = prefixSum[i + k - 1] - prefixSum[i - 1];
        }

        return result;
    }
}