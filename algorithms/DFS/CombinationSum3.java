// lc 216
import java.util.*;
public class CombinationSum3 {
    // time C(9, k) = 9 * 8 * ... * (9 - k + 1), we try 9 - i + 1 numbers in its ith step
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        int min = 0, max = 0;
        for (int i = 1; i <= k; i++) {
            min += i;
            max += (10 - i);
        }
        if (n > max || n < min) return res;
        List<Integer> list = new ArrayList<>();
        dfs(k, n, res, list, 1);
        return res;
    }
    
    private void dfs(int k, int n, List<List<Integer>> res, List<Integer> list, int start) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        else if (k == 0) return;
        for (int i = start; i <= 9; i++) {
            if (i > n) break;
            list.add(i);
            dfs(k - 1, n - i, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
