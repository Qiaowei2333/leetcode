// lc 240
public class SearchA2DMatrix2 {
    // sol2: time O(m + n)
    // https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/66140/My-concise-O(m%2Bn)-Java-solution
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int curRow = 0;
        int curCol = n - 1;
        while (curRow < m && curCol >= 0) {
            if (matrix[curRow][curCol] == target) return true;
            if (matrix[curRow][curCol] > target) {
                curCol--;
            }
            else {
                curRow++;
            }
        }
        return false;
    }
    // sol1: time O(logm * logn)
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
