public class RemoveDuplicatesFromSortedArray {
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