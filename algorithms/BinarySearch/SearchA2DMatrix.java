// lc 74
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid / n][mid % n] == target) {
                return true;
            }
            else if (matrix[mid / n][mid % n] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 4, 5}, {6, 6, 7, 8}};
        SearchA2DMatrix s = new SearchA2DMatrix();
        int result = s.searchMatrix2(matrix, 8);
        System.out.println(result);
    }
}