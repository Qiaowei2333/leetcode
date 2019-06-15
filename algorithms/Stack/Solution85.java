package src.algorithms.Stack;

class Solution85 {
    public static int maximalRectangle(char[][] matrix) {
        int result = 0;
        int m = matrix.length;
        if(m==0) return 0;
        int n = matrix[0].length;
        if(n==0) return 0;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]=='1') {
                    result= Math.max(result, findArea(matrix, i, j, m, n));
                }
            }
        }
        return result;
    }
    public static int findArea(char[][] matrix, int x, int y, int m, int n){
        int countx=1;
        int county=1;
        while((x+countx)<m){
            if(matrix[x+countx][y]=='1') countx++;
            else break;
        }
        while((y+county)<n){
            if(matrix[x][y+county]=='1') county++;
            else break;
        }
        int result = Math.max(countx,county);

        for(int i=1; i<countx; i++){
            for(int j=1; j<county; j++){
                if(matrix[x+i][y+j]!='1') {
                	if(j==1) {
                		countx = i;
                		result = Math.max(result, i*(j+1));
                		break;
                	}
                	else {
                        county = j;
                        result = Math.max(result, (i+1)*j);
                        continue;
                	}
                }
                if(j==county-1) result = Math.max(result, (i+1)*county);
            }
        }
        return Math.max(result, countx*county);
    }
}
