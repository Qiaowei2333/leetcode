// lc 973
import java.util.*;
public class KClosestPointsToOrigin {
    // Priority Queue
    // time O(nlogn) space O(n)
    public int[][] kClosest3(int[][] points, int K) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
        int[][] res = new int[K][2];
        
        for (int[] point : points) {
            pq.offer(point);
        }
        
        for (int i = 0; i < K; i++) {
            int[] temp = pq.poll();
            res[i] = temp;
        }
        
        return res;
    }

    // quick sort
    // O(nlogn)   worstcase O(n2)
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (a, b) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
        System.out.println(Arrays.deepToString(points));
        return Arrays.copyOfRange(points, 0, K);
    }

    // quick select O(n)   space O（1）如果不算最后copy的新数组
    // 假设每次partition取得值都是median，那每次partition都可以去掉一半的数组，所以加起来 N（1 + 1/2 + 1/4 + 1/8 ...） = 2N， 所以是O（n）理想状态下，实际是O（n） to O（nlogn）
    public int[][] kClosest1(int[][] points, int K) {
        int left = 0; 
        int right = points.length - 1;

        while(left < right) {
            int pivotIndex = partition(points, left, right);
            if (pivotIndex == K) { // why we find K not K - 1 th. Because copyOfRnage(points, 0, K) K is exclusive
                break;
            }
            else if (pivotIndex > K) {
                right = pivotIndex - 1;
            }
            else {
                left = pivotIndex + 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private int partition(int[][] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        int pivotValue = nums[mid][0] * nums[mid][0] + nums[mid][1] * nums[mid][1];
        swap(nums, mid, right);
        int pivotIndex = left;
        for (int i = left; i < nums.length; i++) {
            if (nums[i][0] * nums[i][0] + nums[i][1] * nums[i][1] < pivotValue) {
                swap(nums, pivotIndex, i);
                pivotIndex++; // pivotIndex is the next spot you want to swap, because it is a mark of position which has a value bigger than pivotValue
            }
        }
        swap(nums, pivotIndex, right);
        return pivotIndex;
    }

    private void swap(int[][] nums, int a, int b) {
        if (a == b) return; 
        int temp0 = nums[a][0];
        int temp1 = nums[a][1];
        nums[a][0] = nums[b][0];
        nums[a][1] = nums[b][1];
        nums[b][0] = temp0;
        nums[b][1] = temp1;
    }
}