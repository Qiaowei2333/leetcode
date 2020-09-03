// lc 523
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        k = Math.abs(k);
        Map<Integer, Integer> map = new HashMap<>();
        // 在-1的index上放上0，为了处理[0, 0]， k = 0的情况
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) sum = sum % k;  // 处理corner case [23, 2, 4, 6, 7], k = 0
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            else {
                if (i - map.get(sum) >= 2) return true;
            }
        }
        return false;
    }
}
