package src.algorithms;

import java.util.Arrays;

class Solution581 {
    public static int[] findUnsortedSubarray(int[] nums) {
    	int[] result = new int[2];
        int[] n = Arrays.copyOf(nums,nums.length);
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=n[i]){
                min = Math.min(min,i);
                max = Math.max(max,i);
            }
        }
        if(max<0) return null;
        else
        {
        	result[0]=min;
        	result[1]=max;
        	return result;
        }
    }

    public static void main(String[] args) {
    	int[] a = new int[] {2,5,10,8,9,12,20,22,14,15,30};
    	System.out.println(Arrays.toString(findUnsortedSubarray(a)));
    }
}
