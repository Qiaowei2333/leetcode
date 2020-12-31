// lc 329
public class LongestIncreasingPathInAMatrix {
    // 复习的时候看sol2
    // sol1 traverse 其实就是top down的做法，会超时，因为top down，没法记录当前的path，都是从上往下累加的path
    // 所以为了记忆化，用bottom up，在最下面的时候可以记录path值
    private int maximum;
    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int longestIncreasingPath1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maximum = 0;
                dfs(matrix, i, j, 1, dp);
                dp[i][j] = maximum;
                res = Math.max(res, maximum);
            }
        }
        return res;
    }
    
    private void dfs(int[][] matrix, int i, int j, int path, int[][] dp) {
        if (dp[i][j] != 0) {
            maximum = Math.max(maximum, dp[i][j] + path - 1);
            return;
        }
        maximum = Math.max(maximum, path);
        for (int[] dir : dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            
            if(isValid(matrix, newI, newJ)) {
                if (matrix[i][j] < matrix[newI][newJ]) {
                    dfs(matrix, newI, newJ, path + 1, dp); 
                }
            }
        }
    }
    
    private boolean isValid(int[][] matrix, int i, int j) {
        if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
            return true;
        }
        else {
            return false;
        }
    }

    // sol2 记忆化 加 bottom up，也就divide & conquer
    // private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int max = 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int len = dfs(matrix, i, j, n, m, dp);
                max = Math.max(max, len);
            }
        }
        return max;
    }
    
    // return longest increasing path start at i, j
    public int dfs(int[][] matrix, int i, int j, int n, int m, int[][] dp) {
        if (dp[i][j] != 0) return dp[i][j];
        int max = 1;
        for(int[] dir: dirs) {
            int newI = i + dir[0], newJ = j + dir[1];
            if(newI < 0 || newI >= n || newJ < 0 || newJ >= m || matrix[newI][newJ] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, newI, newJ, n, m, dp);
            max = Math.max(max, len);
        }
        dp[i][j] = max;
        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingPathInAMatrix s = new LongestIncreasingPathInAMatrix();
        int[][] matrix = {{7,8,9}, {9,7,6}, {7,2,3}};
        int res = s.longestIncreasingPath(matrix);
        System.out.println(res);
    }
    // 7 8 9
    // 9 7 6
    // 7 2 3
}
