// fb onsite 思路借鉴 lc 23 MergeKSortedLists
import java.util.*;
public class MergeKSortedArray {
    // merge sort
    public int[] mergeKSortedArrays2(int[][] arrays) {
        return mergeKSortedArrays2(arrays, 0, arrays.length - 1);
    }

    private int[] mergeKSortedArrays2(int[][] arrays, int start, int end) {
        if (start > end) return null;
        if (start == end) return arrays[start];
        int mid = (start + end) / 2;
        int[] leftSorted = mergeKSortedArrays2(arrays, start, mid);
        int[] rightSorted = mergeKSortedArrays2(arrays, mid + 1, end);
        return merge(leftSorted, rightSorted);
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                res[k++] = nums1[i++];
            }
            else {
                res[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            res[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            res[k++] = nums2[j++];
        }
        return res;
    }


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
        int[][] input = {};
        int[] res = s.mergeKSortedArrays2(input);
        System.out.println(Arrays.toString(res));
    }
}
