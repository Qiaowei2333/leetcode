import java.util.*;

public class RecoverRotatedSortedArraySolution2 {
    public void recoverRotatedSortedArray(List<Integer> nums) {
        for (int index = 0; index < nums.size() - 1; index++) {
            if (nums.get(index) > nums.get(index + 1)) {
                reverse(nums, 0, index);
                reverse(nums, index + 1, nums.size() - 1);
                reverse(nums, 0, nums.size() - 1);
                return;
            }
        }
    }

    public void reverse(List<Integer> nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j-- ) {
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<Integer>(Arrays.asList(3, 4, 5, 1, 2));
        RecoverRotatedSortedArraySolution2 s = new RecoverRotatedSortedArraySolution2();
        s.recoverRotatedSortedArray(nums);
        System.out.println(nums);
    }

}