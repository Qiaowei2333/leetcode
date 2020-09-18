// lc 611
public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) break;
            int target = nums[i];
            int r = i - 1;
            int l = 0;
            while (l < r) {
                if (nums[l] + nums[r] > target) {
                    // [l] + [r] > target, [l + 1] + [r] > target, [l + 2] + [r] > target,... [r - 1] + [r] > target
                    // e.g. 2,2,2,2,3,4, 4 is target, l is first 2, r is 3
                    count += r - l;
                    r--;
                }
                else {
                    l++;
                }
            }
        }
        return count;
    }
}
