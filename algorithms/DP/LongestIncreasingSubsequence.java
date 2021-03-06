// lc 300 https://www.youtube.com/watch?v=l2rCz7skAlk&ab_channel=HuaHua
import java.util.*;
public class LongestIncreasingSubsequence {
    // dp + greedy (结尾的数越小越好) + binary search， 本质上是patience sorting
    // time O(nlogn)   space O(n)
    // dp[i] 含义 - the smallest ending number of a LIS that has length i + 1
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
        findAllIncreasingSubsequences(nums, 0, nums.length - 1);
        return len;
    }
    
    public List<List<Integer>> findAllIncreasingSubsequences(int[] nums, int start, int end) {
        List<List<Integer>> res = new LinkedList<>();
        if (start == end) {
            res.add(new LinkedList<>());// 加入[]，表示不选当前值
            List<Integer> temp = new LinkedList<>(Arrays.asList(nums[start])); // 选当前值
            len = Math.max(len, temp.size());
            res.add(temp);
            return res;
        }
        List<List<Integer>> subRes = findAllIncreasingSubsequences(nums, start + 1, end);
        for (List<Integer> list : subRes) {
            res.add(list); // start + 1 开始的lic，要加进result
            if (list.size() == 0 || nums[start] < list.get(0)) { // start开始的要判断是不是第一个数，或者递增
                List<Integer> newlist = new LinkedList<>(list);
                newlist.add(0, nums[start]);
                res.add(newlist);
                len = Math.max(len, newlist.size());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence s = new LongestIncreasingSubsequence();
        int res = s.lengthOfLIS(new int[]{1,0,2,3,1});
        System.out.println(res);
    }
}
