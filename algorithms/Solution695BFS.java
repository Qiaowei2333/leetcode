package src.algorithms;

import java.util.LinkedList;

public class Solution695BFS { // BFS 遍历
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]==1) { 
                result = Math.max(result, checkAreaBFS(grid, i, j));
                }
        	}
        }
        return result;
    }
    
    public int checkAreaBFS(int[][] grid, int i, int j) {
    	int m = grid.length;
    	int n = grid[i].length;
    	boolean visited[][] = new boolean[m][n];// 用一个array 判断是否visited
    	grid[i][j]=0;
    	int area =1;
    	// 建立一个queue
    	LinkedList<int[]> queue = new LinkedList<int[]>();
    	// 加root点的位置到queue里面，改为已访问
    	visited[i][j]=true;
    	queue.offer(new int[]{i, j});
    	// 遍历上下左右 未访问的点 加入他们到 queue中
    	int[][] moves = {{1,0},{-1,0},{0,-1},{0,1}};
    	while(!queue.isEmpty()) { // 如果 queue不是空 ， 取出一个，area+1
    		int[] curpos = queue.poll();
        	for(int[] move:moves) {
        		int x = curpos[0] + move[0];
        		int y = curpos[1] + move[1];// 改变现在的位置坐标
        		//查看是否在array范围内，是否是1，是否没有访问过
        		if(islegal(x,y,grid)&&grid[x][y]==1&&!visited[x][y]) {
        			area++;
        			visited[x][y]=true;
        			grid[x][y]=0;
        			queue.offer(new int[] {x,y});
        		}
        		
        	}
    	}

    	return area;
     
    }
    public boolean islegal (int x, int y ,int[][] grid) {
    	return x>=0&&x<grid.length&&y>=0&&y<grid[x].length;
    }
    
    

}
