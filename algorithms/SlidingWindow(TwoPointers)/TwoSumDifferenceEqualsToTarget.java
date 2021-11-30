// lint610  https://yeqiuquan.blogspot.com/2017/04/lintcode-610-two-sum-difference-equals.html
import java.util.*;
public class TwoSumDifferenceEqualsToTarget {
    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        int[] res = new int[2];
        int l = 0;
        int r = 1;
        int n = nums.length;
        while (l < n) {
            while (nums[r] - nums[l] < target) {
                r++;
            }

            while (nums[r] - nums[l] > target) {
                l++;
            }
            if (l == r) r++;
            if (nums[r] - nums[l] == target) {
                res[0] = Math.min(nums[r], nums[l]);
                res[1] = Math.max(nums[r], nums[l]);
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TwoSumDifferenceEqualsToTarget s = new TwoSumDifferenceEqualsToTarget();
        int[] res = s.twoSumDiff(new int[]{2, 2, 2}, 0);
        System.out.println(Arrays.toString(res));
    }

}
