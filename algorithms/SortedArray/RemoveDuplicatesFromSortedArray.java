//Lint100

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int pre = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != nums[pre]) {
                nums[++pre] = nums[i];
            }
        }
        return pre + 1;
    }

    public static void main(String[] args) {

    }
}