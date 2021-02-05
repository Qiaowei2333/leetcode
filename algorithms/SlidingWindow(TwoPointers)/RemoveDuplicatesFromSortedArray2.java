// lint 101, lc 80

public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length <= 2) return nums.length;
        int l = 1;
        int count = 1;
        for (int r = 1; r < nums.length; r++) {
            if (nums[r] == nums[r - 1]) {
                count++;
            }
            else {
                count = 1;
            }
            if (count <= 2) {
                nums[l] = nums[r];
                l++;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 3, 4};
        RemoveDuplicatesFromSortedArray2 s = new RemoveDuplicatesFromSortedArray2();
        int result = s.removeDuplicates(nums);
        System.out.println(result);
    }
}