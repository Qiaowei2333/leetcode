package src.algorithms;

class Solution747 {
    public int dominantIndex(int[] nums) {
        int result = -1;
        int max=-1,smax = -1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]>max) {
                smax = max;
                max = nums[i];
                result = i;
            }
            else if (nums[i]>smax) {
                smax = nums[i];
            }
        }
        if (max>=2*smax) {
            return result;
        }
        else
            return -1;
    }
}
