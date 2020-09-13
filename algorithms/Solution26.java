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
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int slow = 1, fast = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}