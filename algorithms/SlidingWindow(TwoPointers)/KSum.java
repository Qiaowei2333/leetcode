// lc 18 拓展 nums 里面找所有 和等于target的，不重复的，k个数字 的组合
import java.util.*;
public class KSum {
    // k >=2
    public List<List<Integer>> KNumberSum(int[] nums, int target, int k) {
        Arrays.sort(nums);
        return kSumHelper(nums, target, k, 0);
    }

    // From index [start] to [nums.length - 1], find k numbers sum to target
    private List<List<Integer>> kSumHelper(int[] nums, int target, int k, int start) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length - start < k) return res;
        if (k == 2) {
            int l = start, r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum > target) {
                    r--;
                }
                else if (sum < target) {
                    l++;
                }
                else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    res.add(temp);
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;  
                }
            }
            return res;
        } 
        else {
            for (int i = start; i < nums.length; i++) {
                if (i != start && nums[i] == nums[i - 1]) continue;
                List<List<Integer>> tempRes = kSumHelper(nums, target - nums[i], k - 1, i + 1);
                if (!tempRes.isEmpty()) {
                    for (List<Integer> list : tempRes) {
                        list.add(nums[i]);
                        res.add(list);
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        KSum s = new KSum();
        List<List<Integer>> res = s.KNumberSum(new int[]{1, 0, -1, 0, -2, 2}, 0, 4);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
