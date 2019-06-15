package src.algorithms;

import java.util.Arrays;

class Solution268 {
//    public int missingNumber(int[] nums) {
//        int l = nums.length+1;
//        int result =-1;
//        int [] num1 = new int[l];
//        Arrays.fill(num1,-1);
//        for(int num:nums){
//            num1[num]=num;
//        }
//        for(int i=0;i<l;i++){
//            if(num1[i]!=i){
//                return result=i;
//            }
//        }
//        return result;
//    }
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length-1;
        while(left<=right){
            int mid = (left + right)/2;
            if(nums[mid]>mid) right = mid-1;
            else left = mid+1;
        }
        return left;
    }
}
