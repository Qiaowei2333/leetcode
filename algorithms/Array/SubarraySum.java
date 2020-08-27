// lint 138 time O(n) space O(n) - 前缀和
import java.util.*;
public class SubarraySum {
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0) {
                result.add(0);
                result.add(i);
                return result;
            }
            if (map.containsKey(sum)) {
                result.add(map.get(sum) + 1);
                result.add(i);
                return result;
            }
            else {
                map.put(sum, i);
            }
        }
        return result;
    }
}