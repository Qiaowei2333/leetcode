// lc 240
public class SearchA2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m - 1;
        // find last idx < target
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] > target) {
                end = mid - 1;
            }
            else if (matrix[mid][0] < target) {
                start = mid + 1;
            }
            else {
                return true;
            }
        }
        if (end < 0) return false;
        // matrix[end][0] < target
        for (int i = 0; i <= end; i++) {
            if (binarySearch(matrix[i], target)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean binarySearch(int[] nums, int target) {
        int start = 0; 
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            else if (nums[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return false;
    }
}
