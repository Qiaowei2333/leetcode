// lc 53 
public class MaximumSubarray {
    // dp   time O(n)  space O(n)
    public int maxSubArray(int[] nums) {
        if (nums.length < 2) return nums[0];
        int[] d = new int[nums.length];
        d[0] = nums[0];
        int max = d[0];
        for (int i = 1; i < d.length; i++) {
            d[i] = Math.max(d[i - 1] + nums[i], nums[i]);
            max = Math.max(max, d[i]);
        }
        return max;
    }

    // 
}