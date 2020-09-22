// lc 16
public class ThreeSumCloset {
    public int threeSumClosest(int[] nums, int target) {
        // nums.length >= 3
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > target) {
                    r--;
                }
                else if (sum < target) {
                    l++;
                }
                else {
                    return target;
                }
                if (Math.abs(result - target) > Math.abs(sum - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}
