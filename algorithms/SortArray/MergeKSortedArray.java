// fb onsite 思路借鉴 lc 23 MergeKSortedLists
import java.util.*;
public class MergeKSortedArray {
    // min heap  time O(nk*logk)   space O(nk)   k: number of lists, n: average length of each list
    public int[] mergeKSortedArrays(int[][] arrays) {
        if (arrays == null || arrays.length == 0 || arrays[0].length == 0) return new int[0];
        int[] track = new int[arrays.length];
        int[] res = new int[arrays.length * arrays[0].length];
        Queue<Tuple> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < arrays.length; i++) {
            int val = arrays[i][0];
            pq.offer(new Tuple(i, 0, val));
        }
        int m = 0;
        while (!pq.isEmpty()) {
            Tuple temp = pq.poll();
            res[m++] = temp.val;
            int x = temp.x;
            int y = temp.y + 1;
            if (y < arrays[0].length) {
                int nextVal = arrays[x][y];
                Tuple next = new Tuple(x, y, nextVal);
                pq.offer(next);
            }
        }
        return res;
    }

    static class Tuple {
        int x;
        int y;
        int val;
        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        MergeKSortedArray s = new MergeKSortedArray();
        int[][] input = {{1, 10, 11, 15},
                         {2,  4,  9, 14},
                         {5,  6,  8, 16},
                         {3,  7, 12, 13}};
        int[] res = s.mergeKSortedArrays(input);
        System.out.println(Arrays.toString(res));
    }
}
