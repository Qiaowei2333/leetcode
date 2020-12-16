// lc 35
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        // find first index >= target
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4};
        SearchInsertPosition s = new SearchInsertPosition();
        int result = s.searchInsert(A, 4);
        System.out.println(result);
    }
}