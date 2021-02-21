// lc 354 思路借鉴了lc 300  LIS
import java.util.*;
public class RussianDollEnvelopes {
    // dp + greedy + binary search  sol - O(nlogn)
    public int maxEnvelopes1(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            else {
                return a[0] - b[0];
            }
        });
        // LIS dp + greedy sol
        List<Integer> dp = new ArrayList<>();
        for (int i = 0; i < envelopes.length; i++) {
            int curHeight = envelopes[i][1];
            if (dp.isEmpty() || dp.get(dp.size() - 1) < curHeight) {
                dp.add(curHeight);
            }
            else {
                int idx = lowerBound(dp, curHeight);
                dp.set(idx, curHeight);
            }
        }
        return dp.size();
    }

    private int lowerBound(List<Integer> dp, int target) {
        int start = 0;
        int end = dp.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (dp.get(mid) >= target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return start;
    }

    // dp - O(n^2)
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] * a[1] - b[0] * b[1]);
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
