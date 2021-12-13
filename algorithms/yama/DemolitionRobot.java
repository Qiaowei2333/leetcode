// [
//     [1,0,0],
//     [1,0,0],
//     [1,9,1]
// ]
// 从（0，0）= 1 到9，最短走几步
import java.util.*;
public class DemolitionRobot {
    public int minDistanceToRemoveObstacle(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 0;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int newX = cur[0] + dir[0];
                    int newY = cur[1] + dir[1];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] != 0) {
                        if (grid[newX][newY] == 9)
                            return steps;
                        queue.offer(new int[]{newX, newY});
                        grid[newX][newY] = 0;
                    }
                }
            }
        }
        return steps;
    }

    public static void main(String[] args) {   
        DemolitionRobot s = new DemolitionRobot();
        int[][] grid = {
            {1, 1, 1},
            {0, 0, 1},
            {0, 9, 1}
        };
        int res = s.minDistanceToRemoveObstacle(grid);
        System.out.println(res);
    }
}
