// https://www.geeksforgeeks.org/generating-all-possible-subsequences-using-recursion/
// lc 300 LIS brute force解法，找到所有subsequences, 再filter其中递增的, 找到最长的递增的子序列
import java.util.*;
public class FindAllPossibleSubsequences {
    // 此题解法 geeksforgeeks 上有 backtracking的解法
    // O(2^n)
    public List<List<Integer>> findAllSubsequences(int[] nums, int start, int end) {
        List<List<Integer>> res = new LinkedList<>();
        if (start == end) {
            res.add(new LinkedList<>());
            res.add(new LinkedList<>(Arrays.asList(nums[start])));
            return res;
        }
        List<List<Integer>> subRes = findAllSubsequences(nums, start + 1, end);
        for (List<Integer> list : subRes) {
            List<Integer> newlist = new LinkedList<>(list);
            newlist.add(0, nums[start]);
            res.add(list);
            if (newlist.size() == 1 || newlist.get(0) < newlist.get(1)) res.add(newlist);
        }
        return res;
    }

    public static void main(String[] args) {
        FindAllPossibleSubsequences s = new FindAllPossibleSubsequences();
        int[] nums = {1,2,3};
        List<List<Integer>> res = s.findAllSubsequences(nums, 0, nums.length - 1);
        System.out.println(res);
    }
}
