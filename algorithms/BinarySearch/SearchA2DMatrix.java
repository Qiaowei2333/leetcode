public class SearchA2DMatrix {
    private boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        if(matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;
        int start = 0, end = row * column - 1;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            int number = matrix[mid/column][mid%column];
            if(number == target) {
                return true;
            }
            else if(number > target) {
                end = mid;
            }
            else if(number < target){
                start = mid;
            }
        }

        if(matrix[start/column][start%column] == target) {
            return true;
        }
        else if(matrix[end/column][end%column] == target) {
            return true;
        }
        else {
            return false;
        }
    }

    //O(m+n) time and O(1) extra space
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    private int searchMatrix2(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        if(matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int row = matrix.length, column = matrix[0].length,
         x = row - 1, y = 0, count = 0;
        
        while(x >= 0 && y < column) {
            if(matrix[x][y] < target) {
                y++;
            }
            else if(matrix[x][y] > target) {
                x--;
            }
            else{
                count++;
                x--;
                y++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 4, 5}, {6, 6, 7, 8}};
        SearchA2DMatrix s = new SearchA2DMatrix();
        int result = s.searchMatrix2(matrix, 8);
        System.out.println(result);
    }
}