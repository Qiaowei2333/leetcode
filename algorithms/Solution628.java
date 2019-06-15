package src.algorithms;

import java.util.Arrays;

class Solution628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int a = nums[0],b = nums[1];
        int f = nums[nums.length-1], e = nums[nums.length-2], d = nums[nums.length-3];
        return Math.max(a*b*f,d*e*f);
    
    }
}
