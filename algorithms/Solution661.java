package src.algorithms;

class Solution661 {
    public int[][] imageSmoother(int[][] M) {
        int m = M.length;
        int n = M[0].length;
        int[][] result = new int[m][n];
        for (int i =0;i<m;i++) {
            for (int j = 0; j<n; j++) {
                result[i][j] = smoother(i,j,M);  
            }
        }
        return result;
    }
    private int smoother(int i, int j, int[][] M) {
        int[][] moves={{-1,-1},{-1,0},{-1,1},{0,-1},{0,0},{0,+1},{1,-1},{1,0},{1,1}};
        int sum = 0;
        int num = 0;
        for(int[] move:moves ) {
            int x = i+move[0];
            int y = j+move[1];
            if(isLegal(x,y,M)) {
                sum = sum+M[x][y];
                num++;
            }
        }
        return sum/num;
    }
    private boolean isLegal(int x, int y, int[][] M) {
        return x>=0&&x<M.length&&y>=0&&y<M[0].length;
    }
}
