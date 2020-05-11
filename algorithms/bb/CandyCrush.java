// lc 732
public class CandyCrush {
    public int[][] candyCrush(int[][] board) {
        boolean canBeCrushed = true;
        do {
            canBeCrushed = markCandies(board);
            if (canBeCrushed) {
                crashCandies(board);
            }
        } 
        while (canBeCrushed);
        return board;
    }
    
    private boolean markCandies(int[][] board) {
        boolean canBeCrushed = false;
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols - 2; j++) {
              int v = Math.abs(board[i][j]);
              if (v > 0 && v == Math.abs(board[i][j + 1]) && v == Math.abs(board[i][j + 2])) {
                board[i][j] = board[i][j + 1] = board[i][j + 2] = -v;
                canBeCrushed = true;
              }
            }
          }
    
        // Crush vertically
        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols; j++) {
                int v = Math.abs(board[i][j]);
                if (v > 0 && v == Math.abs(board[i + 1][j]) && v == Math.abs(board[i + 2][j])) {
                board[i][j] = board[i + 1][j] = board[i + 2][j] = -v;
                canBeCrushed = true;
                }
            }
        }
        return canBeCrushed;
    }
    

    
    private void crashCandies(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int j = 0; j < cols; j++) {
            int down = rows - 1;
            for (int up = rows - 1; up >= 0; up--) {
                if (board[up][j] > 0) {
                    board[down][j] = board[up][j];
                    down--;
                } 
            }
            for (int k = down; k >= 0; k--) {
                board[k][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = {{110,5,112,113,114},
                         {210,211,5,213,214},
                         {310,311,3,313,314},
                         {410,411,412,5,414},
                         {5,1,512,3,3},
                         {610,4,1,613,614},
                         {710,1,2,713,714},
                         {810,1,2,1,1},
                         {1,1,2,2,2},
                         {4,1,4,4,1014}};
        
        CandyCrush s = new CandyCrush();
        board = s.candyCrush(board);

    }
}