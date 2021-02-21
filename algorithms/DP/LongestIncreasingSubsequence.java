// lc 300
import java.util.*;
public class LongestIncreasingSubsequence {
    // dp + greedy (结尾的数越小越好) + binary search， 本质上是patience sorting
    // time O(nlogn)   space O(n)
    // dp[i] 含义 - the smallest ending number of a subsequence that has length i + 1
    public int lengthOfLIS2(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (dp.isEmpty() || dp.get(dp.size() - 1) < nums[i]) {
                dp.add(nums[i]);
            }
            else {
                int idx = lowerBound(dp, nums[i]);
                dp.set(idx, nums[i]);
            }
        }
        return dp.size();
    }

    private int lowerBound(List<Integer> dp, int target) { // find first element >= target
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

    // dp sol - time O(n^2)  space O(n)
    // dp[i] 含义 - length of the LIS ends with nums[i]
    public int lengthOfLIS1(int[] nums) {
        int res = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) continue;
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // sol - brute force O(2^n)
    private int len = 0;
    public int lengthOfLIS(int[] nums) {
        findAllSubsequences(nums, 0, nums.length - 1);
        return len;
    }
    
    public List<List<Integer>> findAllSubsequences(int[] nums, int start, int end) {
        List<List<Integer>> res = new LinkedList<>();
        if (start == end) {
            res.add(new LinkedList<>());
            List<Integer> temp = new LinkedList<>(Arrays.asList(nums[start]));
            len = Math.max(len, temp.size());
            res.add(temp);
            return res;
        }
        List<List<Integer>> subRes = findAllSubsequences(nums, start + 1, end);
        for (List<Integer> list : subRes) {
            List<Integer> newlist = new LinkedList<>(list);
            newlist.add(0, nums[start]);
            res.add(list);
            if (newlist.size() == 1 || newlist.get(0) < newlist.get(1)) {
                res.add(newlist);
                len = Math.max(len, newlist.size());
            }
        }
        return res;
    }
}
