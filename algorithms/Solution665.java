package src.algorithms;

class Solution665 {
    public static boolean checkPossibility(int[] nums) {
        if(nums.length<3) return true;
        int count =0;
        for(int i=0;i<nums.length-1;i++){
            if(i==0){
                if(nums[i]>nums[i+1]){
                    nums[i]=nums[i+1];
                    count++;
                }
            }
            if(nums[i]>nums[i+1]){
                if(nums[i-1]>nums[i+1]) return false;
                else {
                    nums[i]=nums[i-1];
                    count++;
                    if(count>1) return false;
                }
            }
        }
        return true;
    }
}