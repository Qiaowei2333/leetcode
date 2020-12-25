// lc 53 
public class MaximumSubarray {
    // dp   time O(n)  space O(n)
    public static int maxSubArray(int[] nums) {
        if (nums.length < 2) return nums[0];
        int[] d = new int[nums.length];// d[i] 到i位置，包括i元素的最大的sum  
        d[0] = nums[0];
        int max = d[0];
        for (int i = 1; i < d.length; i++) {
            d[i] = Math.max(d[i - 1] + nums[i], nums[i]);
            max = Math.max(max, d[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int max = maxSubArray(nums);
        System.out.println(max);
    }
}