// Find last index, nums[index] < target
// nums[] all distinct values
//        not distinct values

public class FindLastPos {
    private int findLastSmallerThanTarget(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target) {
                start = mid;
            }
            else if(nums[mid] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if(nums[end] < target) {
            return end;
        }
        else if(nums[end] == target) {
            return end - 1;
        }
        else if(nums[start] < target) {
            return start;
        }
        else if(nums[start] == target) {
            return start - 1;
        }
    }

    public static void main(String args[]) {
        int[] nums = new int[] {1, 1, 3, 3, 4, 5, 6};
        int target = 5;
        FindLastPos s = new FindLastPos();
        System.out.println(s.findLastSmallerThanTarget(nums, target));
    }
}