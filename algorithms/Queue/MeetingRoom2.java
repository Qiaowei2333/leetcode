// lc 253
import java.util.*;
public class MeetingRoom2 {
    // avg time O(nlogn)
    // https://www.youtube.com/watch?v=4MEkBvqE_2Q&ab_channel=%E5%B1%B1%E6%99%AF%E5%9F%8E%E4%B8%80%E5%A7%90
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Queue<Integer> pq = new PriorityQueue<>(); // store the earliest end time for all used rooms
        pq.offer(intervals[0][1]);
        
        for (int i = 1; i < intervals.length; i++) {
            if (pq.peek() <= intervals[i][0]) {
                pq.poll();
                pq.offer(intervals[i][1]);
            }
            else {
                pq.offer(intervals[i][1]);
            }
          
        }
        return pq.size();
    }
}