// 给一个2d array，一个起点和一个终点，中间可能有block，只能向右拐和直走，问能不能成功从起点走到终点。S是起点，D是终点，X是block，一开始是面向右边。
// 0 0 0 0 0
// 0 X 0 D 0
// 0 0 X 0 X
// 0 S 0 0 0
// 0 0 0 X 0 
import java.util.*;
public class FindEnd {
    private int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    // bfs time O(m * n)
    public boolean canArriveAtEndPointBFS(char[][] array, int startX, int startY) {
        Queue<Coordinate> queue = new LinkedList<>();
        boolean[][] visited = new boolean[array.length][array[0].length];
        queue.offer(new Coordinate(startX, startY));
        visited[startX][startY] = true;
        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();
            if (array[cur.x][cur.y] == 'D') return true;
            for (int[] direction : directions) {
                int x = direction[0] + cur.x;
                int y = direction[1] + cur.y;
                if (x >= 0 && x < array.length && y >= 0 && y < array[0].length && !visited[x][y] && array[x][y] != 'X') {
                    visited[x][y] = true;
                    queue.offer(new Coordinate(x, y));
                }
            }
        }
        return false;
    }

    static class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // dfs time O(m * n)
    public boolean canArriveAtEndPointDFS(char[][] array, int startX, int startY) {
        if (array == null || array.length == 0 || array[0].length == 0) return false;
        if (array[startX][startY] == 'D') return true;
        array[startX][startY] = '1';
        for (int[] direction : directions) {
            int x = startX + direction[0];
            int y = startY + direction[1];
            if (isValid(x, y, array)) {
                if(canArriveAtEndPointDFS(array, x, y)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(int x, int y, char[][] array) {
        if (x >= 0 && x < array.length && y >= 0 && y < array[0].length && (array[x][y] == '0' || array[x][y] == 'D')) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        char[][] array = new char[][]{
            {'0', '0', '0', '0', '0'},
            {'X', 'X', '0', 'D', '0'},
            {'0', '0', 'X', 'X', '0'},
            {'0', 'S', '0', '0', '0'},
            {'0', '0', '0', 'X', '0'}
        };
        FindEnd s = new FindEnd();
        boolean res = s.canArriveAtEndPointDFS(array, 3, 1);
        System.out.println(res);
    }
}
