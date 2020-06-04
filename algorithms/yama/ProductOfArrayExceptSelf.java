// lc 238
// time O(nlogn), space O(n)
import java.util.*;
public class ProductOfArrayExceptSelf {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return intervals;
        }
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int newStart = intervals[i][0];
            int newEnd = intervals[i][1];
            if (newStart > end) {
                list.add(new int[]{start, end});
                start = newStart;
                end = newEnd;
            }
            else {
                if (newEnd > end) {
                    end = newEnd;
                }
            }
        }
        list.add(new int[]{start, end});
        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf s = new ProductOfArrayExceptSelf();
        int[][] result = s.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        System.out.println(Arrays.deepToString(result));
    }
}