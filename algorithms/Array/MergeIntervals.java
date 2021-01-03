// lc 56
import java.util.*;
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> temp = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end  = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int newStart = intervals[i][0];
            int newEnd = intervals[i][1];
            if (newStart <= end) {
                end = Math.max(end, newEnd);
            }
            else {
                temp.add(new ArrayList<>(Arrays.asList(start, end)));
                start = newStart;
                end = newEnd;
            }
        }
        temp.add(new ArrayList<>(Arrays.asList(start, end)));
        int[][] res = new int[temp.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i][0] = temp.get(i).get(0);
            res[i][1] = temp.get(i).get(1);
        }
        return res;
    }
}
