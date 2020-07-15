// lc 973
import java.util.*;
public class KClosestPointsToOrigin {
    // quick sort
    
    // O(nlogn)
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (a, b) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
        System.out.println(Arrays. deepToString(points));
        return Arrays.copyOfRange(points, 0, K);
    }
}