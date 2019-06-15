package src.algorithms;

public class Solution624 {
	  static int maxDistance(int[][] list) {
		 int Min=Integer.MAX_VALUE;
		 int Max=Integer.MIN_VALUE;
		 for(int[] nums:list) {
			 Min = Math.min(Min, nums[0]);
			 Max = Math.max(Max, nums[nums.length-1]);
		 }
		 return Max-Min;
	 }
}
