// lc 378 类似 MergeKSortedArray
import java.util.*;
public class KthSmallestElementInASortedMatrix {
    // time O(klogn + n)  space O(n)
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Tuple> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < matrix.length; i++) {
            int val = matrix[i][0];
            pq.offer(new Tuple(i, 0, val));
        }

        for (int j = k; j > 1; j--) {
            Tuple cur = pq.poll();
            int x = cur.x;
            int y = cur.y + 1;
            if (y < matrix[0].length) {
                int val = matrix[x][y];
                pq.offer(new Tuple(x, y, val));
            }
        }
        return pq.peek().val;
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
}
