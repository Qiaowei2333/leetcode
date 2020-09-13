// lint 101, lc 80

public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length < 3) return nums.length;
        int slow = 1, fast = 1, repeat = 1;
        while (fast < nums.length) {
            if (nums[fast] == nums[fast - 1]) {
                repeat++;
            }
            else {
                repeat = 1;
            }
            if (repeat <= 2) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 3, 4};
        RemoveDuplicatesFromSortedArray2 s = new RemoveDuplicatesFromSortedArray2();
        int result = s.removeDuplicates(nums);
        System.out.println(result);
    }
}