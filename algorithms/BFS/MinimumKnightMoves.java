// lc 1197
import java.util.*;
public class MinimumKnightMoves {
    // 1. 此题重点是棋盘上的位置怎么记录，如何知道已经visited过了
    // 用 Map<Integer, Set<Integer>>, key 为X，value for set of Y
    // 2. 优化方法，把x, y限定在第一象限，注意此时newX，newY必须是>=2的
    public int minKnightMoves(int x, int y) {
        if (x == 0 && y == 0) {
          return 0;  
        }
        x = Math.abs(x);
        y = Math.abs(y);
        int[][] directions = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
        
        Queue<Coordinate> queue = new LinkedList<>();
        Map<Integer, Set<Integer>> checkMap = new HashMap<>();
        Coordinate origin = new Coordinate(0, 0);
        queue.offer(origin);
        checkMap.put(0, new HashSet<>());
        checkMap.get(0).add(0);
        
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                Coordinate cur = queue.poll();
                for (int j = 0; j < directions.length; j++) {
                    int newX = cur.x + directions[j][0];
                    int newY = cur.y + directions[j][1];
                    if (newX == x && newY == y) {
                        return steps;
                    }
                    if (!checkMap.containsKey(newX)) {
                        checkMap.put(newX, new HashSet<>());
                    }
                    if (!checkMap.get(newX).contains(newY) && newX >= -2 && newY >= -2) {
                        checkMap.get(newX).add(newY);
                        queue.offer(new Coordinate(newX, newY));
                    }
                }
            }
            
        }
        return -1;
    }
    
    static class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}