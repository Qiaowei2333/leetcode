//yama oa time complex O(row*col)
import java.util.*;
public class ZombieInMatrix {

    static class Coordinate {
        int row, col;
        public Coordinate(int x, int y) {
            this.row = x;
            this.col = y;
        }
    }

    public int minHours(int rows, int columns, List<List<Integer>> grid) {
        if (grid == null || rows == 0 || columns == 0) {
            return 0;
        }


        Queue<Coordinate> queue = new LinkedList<>();

        int numPeople = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid.get(i).get(j) == 1) {
                    queue.offer(new Coordinate(i, j));
                } else {
                    numPeople++;
                }
            }
        }

        if (numPeople == 0) {
            return 0;
        }

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int hours = 0;
        while (!queue.isEmpty()) {
            hours++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinate cur = queue.poll();
                System.out.println("originalrow:" + cur.row);
                System.out.println("originalcol:" +cur.col);
                for (int j = 0; j < dir.length; j++) {
                    int[] delta = dir[j];
                    int newRow = cur.row + delta[0];
                    int newCol = cur.col + delta[1];
                    System.out.println("newrow:" + newRow);
                    System.out.println("newcol:" + newCol);
                    if (isPeople(newRow, newCol, grid, rows, columns)) {
                        grid.get(newRow).set(newCol, 1);
                        numPeople--;
                        if (numPeople == 0) {
                            return hours;
                        }
                        queue.offer(new Coordinate(newRow, newCol));
                    }
                }
            }
        }

        return -1;
    }

    private boolean isPeople(int row, int col, List<List<Integer>> grid, int rowsBound, int colsBound) {
        if (row < 0 || row >= rowsBound || col < 0 || col >= colsBound) {
            return false;
        } else if (grid.get(row).get(col) == 1) {
            return false;
        } else {
            return true;
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
        List<Integer> row0 = Arrays.asList(new Integer[] {0});
        List<Integer> row1 = Arrays.asList(new Integer[] {0});
        List<Integer> row2= Arrays.asList(new Integer[] {0});
        List<Integer> row3 = Arrays.asList(new Integer[] {0});
        grid.add(row0);
        grid.add(row1);
        grid.add(row2);
        grid.add(row3);

        ZombieInMatrix s = new ZombieInMatrix();
        int hours = s.minHours(grid.size(), grid.get(0).size(), grid);

        System.out.println(hours);
    }
}