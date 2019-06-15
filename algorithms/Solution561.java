package src.algorithms;

// 2017/9/12 1

import java.util.Arrays; // Â©µôimport

class Solution561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i=0; i<nums.length; i+=2){ // Â©µôÁË int i
            sum+=nums[i];
        }
        return sum;
    }
}