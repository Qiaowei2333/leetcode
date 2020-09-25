// lc 532
import java.util.*;
public class KDiffPairsInAArray {
    // hashmap<val, frequency>
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        // why we need hashmap not hashset, because we need to know how many times a number appear. 
        // hashset not working for this case [1,3,1,1,5,4] k = 0, we have three 1
        // 1 - 1 = 0 so count = 1. but we only need to count the appearance of second 1, for the third 1, it is a duplicate pair
        Map<Integer, Integer> map = new HashMap<>();
        int count= 0;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (!map.containsKey(val)) {
                if (map.containsKey(val - k)) count++;
                if (map.containsKey(val + k)) count++;
                map.put(val, 1);
            }
            else {
                if (k == 0 && map.get(val) == 1) count++;
                map.put(val, map.get(val) + 1);
            }
        }
        return count;
    }

    // two pointers
    public int findPairs1(int[] nums, int k) {
        if (k < 0 || nums == null || nums.length < 2) return 0;
        Arrays.sort(nums);
        int res = 0;
        int l = 0, r = 0;
        while (r < nums.length) {
            if (l == r) r++;
            while (r < nums.length && nums[r] - nums[l] < k) r++;
            while (r < nums.length && l < r && nums[r] - nums[l] >= k) {
                if (nums[r] - nums[l] == k) {
                    res++;
                    l++;
                    r++;
                    while (r < nums.length && nums[r] == nums[r - 1]) r++;
                    while (r < nums.length && l < r && nums[l] == nums[l - 1]) l++;
                }
                else {
                    l++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        KDiffPairsInAArray s = new KDiffPairsInAArray();
        int res = s.findPairs1(new int[]{1, 2, 3, 4, 5}, 2);
        System.out.println(res);
    }
}
