// lc 1010 Pairs of Songs With Total Durations Divisible by 60
import java.util.*;
public class AmazonMusicPairs {
    // time O(n) space O(1)
    public int numPairsDivisibleBy60(int[] time) {
        if (time == null || time.length == 0) return 0;
        int ct0 = 0;
        for (int i = 0; i < time.length; i++) {
            time[i] %= 60;
            if (time[i] == 0) ct0++;
        }
        int res = ct0 * (ct0 - 1) / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : time) {
            if (t == 0) continue;
            if (map.containsKey(60 - t)) {
                res += map.get(60 - t);
            }
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        return res;
    }
}
