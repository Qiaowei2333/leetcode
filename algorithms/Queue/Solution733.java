import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution733 {
  
//   image = [[1,1,1],
  //          [1,1,0],
  //          [1,0,1]
  // ]
//   sr = 1, sc = 1, newColor = 2
//   Output: [[2,2,2],[2,2,0],[2,0,1]]
  
  
  static class Point {
    int x;
    int y;
    int color;
    public Point(int x, int y, int color) {
      this.x = x;
      this.y = y;
      this.color = color;
    }
  }
  
  private int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
      Queue<Point> queue = new LinkedList<>();
      Set<Point> visited = new HashSet<>();
      
      Point start = new Point(sr, sc, image[sr][sc]);
      queue.add(start);
      visited.add(start);

      
      while (!queue.isEmpty()) {
          
          Point curr = queue.poll();
          for (int[] dir : DIRS) {
              int nextX = curr.x + dir[0];
              int nextY = curr.y + dir[1];
            
              if (isInvalid(image, curr, nextX, nextY)) {
                  continue;
              }
              Point nextPoint = new Point(nextX, nextY, image[nextX][nextY]);
            
              if (!visited.contains(nextPoint)) {
                
                  image[nextX][nextY] = newColor;
                  queue.add(nextPoint);
                  visited.add(nextPoint);
              }
              
             
              
          }
      }
      return image;
  }
  
  public boolean isInvalid(int[][] image, Point curr, int x, int y) {
    return x < 0 || x >= image.length || y < 0 || y >= image[0].length;
      
  }
  
  
  public static void main(String[] args) {
    Solution733 s = new Solution733();
 
    int[][] image = {
      {1,1,1},
      {1,1,0},
      {1,0,1}
    };
    
    int[][] res = s.floodFill(image, 1, 1, 2);
    
    for (int i = 0; i < res.length; i++) {
        for (int j = 0; j < res[0].length; j++) {
            System.out.print(res[i][j] + " ");
        }
        System.out.println();
    }
  }
}

