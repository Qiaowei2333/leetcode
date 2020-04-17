// lt 52 https://www.youtube.com/watch?v=Poh9n6RxNvw
import java.util.*;
public class NQueens2 {
    private int result = 0;
    private Set<Integer> diff = new HashSet<>();
    private Set<Integer> sum = new HashSet<>();
    private Set<Integer> cols = new HashSet<>();
    public int totalNQueens(int n) {
        if (n <= 0) {
            return result;
        }
        
        dfs(0, n);
        return result;
    }
    
    private void dfs(int row, int n) {
        if (row == n) {
            result++;
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || diff.contains(row - col) || sum.contains(row + col)) {
                continue;
            }
            cols.add(col);
            diff.add(row - col);
            sum.add(row + col);
            dfs(row + 1, n);
            cols.remove(col);
            diff.remove(row - col);
            sum.remove(row + col);
        }
    }
}