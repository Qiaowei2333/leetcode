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

    // greedy思想   time O(n)  space O(1)
    // https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
    // method2
    public int maxSubArrayGreedy(int[] nums) {
        if (nums.length < 2) return nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        
        int lowestValue = 0, r = 0;
        int maxDiff = nums[0];
        for (;r < nums.length; r++) {
            if (nums[r] - lowestValue > maxDiff) {
                maxDiff = nums[r] - lowestValue;
            }
            if (nums[r] < lowestValue) {
                lowestValue = nums[r];
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int max = maxSubArray(nums);
        System.out.println(max);
    }
}