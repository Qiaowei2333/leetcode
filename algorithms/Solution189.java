package src.algorithms;

import java.util.Arrays;

public class Solution189 {
//	public static void  rotate(int[] nums, int k) {
//    k %= nums.length;
//    reverse(nums, 0, nums.length - 1);
//    reverse(nums, 0, k - 1);
//    reverse(nums, k, nums.length - 1);
//}
//
//public static void reverse(int[] nums, int start, int end) {
//    while (start < end) {
//        int temp = nums[start];
//        nums[start] = nums[end];
//        nums[end] = temp;
//        start++;
//        end--;
//    }
//}
	    public static void rotate(int[] nums, int k) {
	        int[] a = Arrays.copyOf(nums,nums.length);
	        k = k % nums.length;
	        if(k==0) return;
	        for(int i=0; i<nums.length; i++){
	            if(i<k){
	                nums[i]=a[nums.length-k+i];
	            }
	            else
	                nums[i]=a[i-k];
	        }
	    }
	}


