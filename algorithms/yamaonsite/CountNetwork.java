// 1 1 1 1 1 1
// 1 1 1 1 1 1
// 2 2 2 2 2 2
// 2 2 2 2 2 2
// 1 1 1 1 1 1
import java.util.*;
public class CountNetwork {
    public int countNetwork(int[][] people) {
        int count = 0;
        for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < people[0].length; j++) {
                if (people[i][j] != 0) {
                    count++;
                    dfs(i, j, people, people[i][j]);
                } 
            }
        }
        return count;
    }

    private void dfs(int x, int y, int[][] people, int iniValue) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        people[x][y] = 0;
        for (int[] direction : directions) {
            int newX = direction[0] + x;
            int newY = direction[1] + y;
            if (isValid(newX, newY, people) && people[newX][newY] == iniValue) {
                dfs(newX, newY, people,iniValue);
            }
        }
    }

    private void bfs(int i, int j, int[][] people, int iniValue) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(i, j));
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();
            for (int[] direction : directions) {
                int newX = direction[0] + cur.x;
                int newY = direction[1] + cur.y;
                if (isValid(newX, newY, people) && people[newX][newY] == iniValue) {
                    people[newX][newY] = 0;
                    queue.offer(new Coordinate(newX, newY));
                }
            }
        }
    }

    private boolean isValid(int x, int y, int[][] array) {
        if (x >= 0 && x < array.length && y >= 0 && y < array[0].length) {
            return true;
        }
        else {
            return false;
        }
    }

    static class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        CountNetwork s = new CountNetwork();
        int[][] people = {
            {1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1},
            {2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2},
            {1, 1, 1, 1, 1, 1}
        };
        int res = s.countNetwork(people);
        System.out.println(res);
    }
}
