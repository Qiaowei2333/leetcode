// lint610  https://yeqiuquan.blogspot.com/2017/04/lintcode-610-two-sum-difference-equals.html
import java.util.*;
public class TwoSumDifferenceEqualsToTarget {
    static class Pair {
        int val;
        int index;
        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public int[] twoSumDiff(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        int[] res = new int[2];
        Pair[] newArr = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArr[i] = new Pair(nums[i], i);
        }
        Arrays.sort(newArr, (a, b) -> a.val - b.val);
        target = Math.abs(target);
        int l = 0, r = 0;
        while (r < newArr.length) {
            if (l == r) { r++; }
            while (r < newArr.length && newArr[r].val - newArr[l].val < target) {
                r++;
            }

            while (l < r && r < newArr.length && newArr[r].val - newArr[l].val >= target) {
                if (newArr[r].val - newArr[l].val == target) {
                    res[0] = newArr[l].index + 1;
                    res[1] = newArr[r].index + 1;
                    return res;
                }
                l++;     
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
