// lc 51   youtube.com/watch?v=_ey1pyQy7Bg&t=445s
import java.util.*;
public class NQueens {

    Set<Integer> cols = new HashSet<>();
    Set<Integer> diff = new HashSet<>();
    Set<Integer> sum = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(board, n, 0, result);
        return result;
    }
    
    private void dfs(char[][] board, int n, int row, List<List<String>> result) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String temp = new String(board[i]);
                solution.add(temp);
            }
            result.add(solution);
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || diff.contains(row - col) || sum.contains(row + col)) {
                continue;
            }
            cols.add(col);
            diff.add(row - col);
            sum.add(row + col);
            board[row][col] = 'Q';
            dfs(board, n, row + 1, result);
            cols.remove(col);
            diff.remove(row - col);
            sum.remove(row + col);
            board[row][col] = '.';
        }
    }

    public static void main(String[] args) {
        NQueens s = new NQueens();
        List<List<String>> result = s.solveNQueens(2);
        System.out.println(result);
    }

}