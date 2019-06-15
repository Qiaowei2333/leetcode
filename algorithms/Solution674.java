package src.algorithms;

class Solution674 {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length<1) return 0;
        int LCIS=1;
        int max=-1;
        for(int i=0; i<nums.length-1;i++) {
            if(nums[i]<nums[i+1]){
                LCIS++;
            }
            else {
            	max=Math.max(max, LCIS);
                LCIS=1;
            }
        }
        return Math.max(max, LCIS);
    }
}
