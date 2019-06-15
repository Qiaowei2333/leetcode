package src.algorithms;

import java.util.LinkedList;

public class Solution695BFS { // BFS ����
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
    	boolean visited[][] = new boolean[m][n];// ��һ��array �ж��Ƿ�visited
    	grid[i][j]=0;
    	int area =1;
    	// ����һ��queue
    	LinkedList<int[]> queue = new LinkedList<int[]>();
    	// ��root���λ�õ�queue���棬��Ϊ�ѷ���
    	visited[i][j]=true;
    	queue.offer(new int[]{i, j});
    	// ������������ δ���ʵĵ� �������ǵ� queue��
    	int[][] moves = {{1,0},{-1,0},{0,-1},{0,1}};
    	while(!queue.isEmpty()) { // ��� queue���ǿ� �� ȡ��һ����area+1
    		int[] curpos = queue.poll();
        	for(int[] move:moves) {
        		int x = curpos[0] + move[0];
        		int y = curpos[1] + move[1];// �ı����ڵ�λ������
        		//�鿴�Ƿ���array��Χ�ڣ��Ƿ���1���Ƿ�û�з��ʹ�
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
