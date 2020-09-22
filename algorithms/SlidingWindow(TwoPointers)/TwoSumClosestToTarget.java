// lint 533
public class TwoSumClosestToTarget {
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        int diff = Integer.MAX_VALUE;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum > target) {
                r--;
                diff = Math.min(diff, sum - target);
            }
            else if (sum < target) {
                l++;
                diff = Math.min(diff, target - sum);
            }
            else {
                return 0;
            }
        }
        return diff;
    }
}