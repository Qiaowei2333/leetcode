// lint 139
import java.util.*;
public class SubarraySumClosest {
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] result = new int[2];
        List<int[]> preSum = new ArrayList<>();
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            preSum.add(new int[]{i, sum});
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                result[0] = 0;
                result[1] = i;
            }
        }
        Collections.sort(preSum, (a, b) -> a[1] - b[1]);
        for (int j = 1; j < preSum.size(); j++) {
            int[] a = preSum.get(j - 1);
            int[] b = preSum.get(j);
            int diff = b[1] - a[1];
            if (min > diff) {
                min = diff;
                result[0] = Math.min(a[0], b[0]) + 1;
                result[1] = Math.max(a[0], b[0]);
            }
        }
        return result;
    }
}