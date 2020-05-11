// lc 253
import java.util.*;
public class MeetingRoom2 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        Queue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int newSt = intervals[i][0];
            int newEd = intervals[i][1];
            int earliest = pq.poll();
            if (newSt < earliest) {
                pq.offer(newEd);
                pq.offer(earliest);
            } else {
                pq.offer(newEd);
            }
        }
        
        return pq.size();
    }
}