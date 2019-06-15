package src.algorithms;

class Solution695 { // dfs ±éÀú
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]==1) { 
                result = Math.max(result, checkArea(grid, i, j, 1));
                }
        	}
        }
        return result;
    }
    public int checkArea(int[][] grid1, int i, int j, int area) {
        grid1[i][j]=0;
        if(i>0 && j>0 && j+1<grid1[0].length && i+1<grid1.length && grid1[i][j+1]==0 && grid1[i+1][j]==0 && grid1[i][j-1]==0 && grid1[i-1][j]==0) {
            return area;
        }
        if (j+1<grid1[0].length && grid1[i][j+1]==1) {
        	area++;
            area = checkArea(grid1, i,j+1, area);
        }
        if (i+1<grid1.length&&grid1[i+1][j]==1) {
        	area++;
            area = checkArea(grid1, i+1,j, area);                
        }
        if (i>0 && grid1[i-1][j]==1) {
        	area++;
            area = checkArea(grid1, i-1,j, area);                
        }
        if (j>0 && grid1[i][j-1]==1) {
        	area++;
            area = checkArea(grid1, i,j-1, area);                
        }
        
        return area; 
    }
}
