package src.algorithms;

//2017/9/12 2

class Solution566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int clm = nums[0].length;
        int[][] NewNums = new int[r][c];//define array of array
        int ii,jj;//coordinates of old array
        int order;
        if((row*clm)==(r*c)) {
            for(int i = 0; i<r; i++) {
                for(int j = 0; j<c; j++) {
                 order = i*c+j; 
                 ii = order/clm;
                 jj = order%clm;
                 NewNums[i][j] = nums[ii][jj];   
                }
            }
            return NewNums;
        }
        else {
            return nums;
        }
    }
}
