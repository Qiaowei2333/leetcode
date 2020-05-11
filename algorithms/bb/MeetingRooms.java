// lc 252
import java.util.*;
public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int earliest = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int newSt = intervals[i][0];
            int newEd = intervals[i][1];
            
            if (earliest > newSt) {
                return false;
            } 
            else {
                earliest = newEd;
            } 
        }
        
        return true;
    }
}