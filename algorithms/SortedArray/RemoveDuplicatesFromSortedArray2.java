// lint 101

public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[index]) {
                if (count < 2) {
                    nums[++index] = nums[i];
                    count ++;
                }
            } else {
                nums[++index] = nums[i];
                count = 1;
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 3, 4};
        RemoveDuplicatesFromSortedArray2 s = new RemoveDuplicatesFromSortedArray2();
        int result = s.removeDuplicates(nums);
        System.out.println(result);
    }
}