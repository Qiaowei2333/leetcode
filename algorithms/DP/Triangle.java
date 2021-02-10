// lc 120
import java.util.*;
public class Triangle {
    // dfs + memorization, time O(n^2), 1+2..+n 一共 n(n+1)/2 点，每个都走了一遍， space O(n), stack 栈空间为深度n
    private Integer[][] dp; 
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int maxCol = triangle.get(rows - 1).size();
        dp = new Integer[rows][maxCol];
        int res = dfsHelper(triangle, 0, 0, rows);
        return res;
    }

    private int dfsHelper(List<List<Integer>> triangle, int row, int col, int rows) {
        if (row == rows - 1) return triangle.get(row).get(col);
        if (dp[row][col] != null) return dp[row][col];
        int left = dfsHelper(triangle, row + 1, col, rows);
        int right = dfsHelper(triangle, row + 1, col + 1, rows);
        int res = Math.min(left, right) + triangle.get(row).get(col);
        dp[row][col] = res;
        return res;
    }

    // dp sol - 2d dp array
    public int minimumTotalDP(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int cols = triangle.get(rows - 1).size();
        Integer[][] dp = new Integer[rows][cols];
        for (int i = 0; i < cols; i++) {
            dp[rows - 1][i] = triangle.get(rows - 1).get(i);
        }
        
        for (int i = rows - 2; i >= 0; i--) {
            List<Integer> lvl = triangle.get(i);
            for (int j = 0; j < lvl.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + lvl.get(j);
            } 
        }
        return dp[0][0];
    }

    // dp sol - 1d dp arrau
    public int minimumTotal1(List<List<Integer>> triangle) {
        int rowNum = triangle.size();
        int[] dp = new int[rowNum];
        for (int i = 0; i < triangle.get(rowNum - 1).size(); i++) {
            dp[i] = triangle.get(rowNum - 1).get(i);
        }
        for (int row = rowNum - 2; row >= 0; row--) {// for each layer
            for (int col = 0; col <= row; col++) {
                dp[col] = Math.min(dp[col], dp[col + 1])
                        + triangle.get(row).get(col);
            }
        }
        return dp[0];
    }
    

    public static void main(String[] args) {
        Triangle s = new Triangle();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(2)));
        triangle.add(new ArrayList<>(Arrays.asList(3, 4)));
        triangle.add(new ArrayList<>(Arrays.asList(6,5,7)));
        triangle.add(new ArrayList<>(Arrays.asList(4,1,8,3)));
        int res = s.minimumTotal1(triangle);
        System.out.println(res);
    }
}
