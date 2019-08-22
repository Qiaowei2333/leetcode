public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        if(matrix[0][0] > target || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;
        }
        if(matrix.length == 1) {
            return searchMatrixRow(matrix[0], target);
        }

        int start = 0, end = matrix.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(matrix[mid][0] == target) {
                return true;
            }
            else if(matrix[mid][0] > target) {
                end = mid;
            }
            else if(matrix[mid][0] < target){
                start = mid;
            }
        }

        int targetRow = -1;
        if(matrix[start][0] == target) {
            return true;
        }
        else if(matrix[start][0] > target) {
            targetRow = start - 1;
            if(targetRow < 0) {
                return false;
            }
            else {
                return searchMatrixRow(matrix[targetRow], target);
            }
        }
        else if(matrix[end][0] == target) {
            return true;
        }
        else if(matrix[end][0] > target) {
            
            targetRow = end - 1;
            return searchMatrixRow(matrix[targetRow], target);
        }
        else if(target > matrix[end][0]) {
            targetRow = end;
            return searchMatrixRow(matrix[targetRow], target);
        }
        else {
            return false;
        }
    }

    private boolean searchMatrixRow(int[] matrixRow, int target) {
        if(matrixRow == null || matrixRow.length == 0) {
            return false;
        }

        int start = 0, end = matrixRow.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(matrixRow[mid] == target) {
                return true;
            }
            else if(matrixRow[mid] > target) {
                end = mid;
            } 
            else if(matrixRow[mid] < target ) {
                start = mid;
            }
        }

        if(matrixRow[start] == target) {
            return true;
        }
        if (matrixRow[end] == target) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {null, {1, 4, 5}, {6, 7, 8}};
        SearchA2DMatrix s = new SearchA2DMatrix();
        boolean result = s.searchMatrix(matrix, 8);
        System.out.println(result);
    }
}