// lc 33
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0; 
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) return mid;
            if (target >= nums[0]) {
                if (nums[mid] > target || nums[mid] < nums[0]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            else {
                if (nums[mid] <= target || nums[mid] >= nums[0]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1; 
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        int[] A = {1001,10001,10007,1,10,101,201};
        int result = s.search(A, 10001);
        System.out.println(result);
    }
}