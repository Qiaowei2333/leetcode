// Find first index, num[index] >= target
// num[]: all values are distinct ----> return mid;
//         not distinct --------------> end = mid;

public class FindFirstPos {
    private int findFirstBiggerOrEqualThanTarget(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target) {
                end = mid;// nums values are not distinct
            }
            else if(nums[mid] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if(nums[start] >= target) {
            return start;
        }
        else if(nums[end] >= target) {
            return end;
        }
        else {
            return end + 1;
        }
    }
    public static void main(String args[]) {
        int[] nums = new int[] {1, 1, 3, 3, 4, 5, 6};
        int target = 7;
        FindFirstPos s = new FindFirstPos();
        System.out.println(s.findFirstBiggerOrEqualThanTarget(nums, target));
    }
}