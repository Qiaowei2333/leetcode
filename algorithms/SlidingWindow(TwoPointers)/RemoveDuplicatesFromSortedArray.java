//Lint100 lc 26

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] > nums[l]) {
                l++;
                nums[l] = nums[r];
            }
        }
        return l + 1;
    }
}