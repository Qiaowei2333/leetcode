// fb onsite 思路借鉴 lc 23 MergeKSortedLists
import java.util.*;
public class MergeKSortedArray {
    // min heap  time O(nk*logk)   space O(nk)   k: number of lists, n: average length of each list
    public int[] mergeKSortedArrays(int[][] arrays) {
        if (arrays == null || arrays.length == 0 || arrays[0].length == 0) return new int[0];
        int[] track = new int[arrays.length];
        int[] res = new int[arrays.length * arrays[0].length];
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < arrays.length; i++) {
            int val = arrays[i][0];
            int pos = i;
            pq.offer(new Pair(val, pos));
            track[pos]++;
        }
        int m = 0;
        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            res[m++] = temp.val;
            int posInArr = track[temp.pos]++;
            if (posInArr < arrays[0].length) {
                int nextVal = arrays[temp.pos][posInArr];
                Pair next = new Pair(nextVal, temp.pos);
                pq.offer(next);
            }
        }
        return res;
    }

    static class Pair {
        int val;
        int pos;
        public Pair(int val, int pos) {
            this.val = val;
            this.pos = pos;
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
