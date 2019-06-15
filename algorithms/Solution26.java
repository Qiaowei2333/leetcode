package src.algorithms;

//class Solution26 {
//    public int removeDuplicates(int[] nums) {
//        int repeat = 0;
//        for(int i=0;i<nums.length-1;i++){
//           if(nums[i]==nums[i+1]) repeat++;
//            else nums[i+1-repeat]=nums[i+1];
//        }
//        return nums.length-repeat;
//    }
//}
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int j = 0; //current index
        for (int i = 1; i<nums.length; i++) { 
            if (nums[i] != nums[j]) { //new number
                j++; //move current index
                nums[j] = nums[i]; //fill current index with new number
            } 
        }
    return j+1;
   }
}