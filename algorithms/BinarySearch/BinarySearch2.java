import java.util.*;

public class BinarySearch2 {
    public int binarySearch2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid - 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        if (nums[start] == target) {
            return start;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 0,0,1,1, 1};
        BinarySearch2 bs = new BinarySearch2();
        int targetIndex = bs.binarySearch2(nums, 1);
        System.out.println(targetIndex);
    }

}