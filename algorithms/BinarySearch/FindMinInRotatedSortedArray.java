// lc 153
public class FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int target = nums[start];
        // find first element < nums[start]
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid + 1;
            }
            else if (nums[mid] > target) {
                start = mid + 1;
            }
            else if (nums[mid] < target) {
                end = mid - 1;
            }
        }

        if (start < nums.length) {
            return nums[start];
        }
        return nums[0];
    }
}