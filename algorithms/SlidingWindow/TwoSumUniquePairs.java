// lin587
import java.util.*;
public class TwoSumUniquePairs {
    public int twoSum6(int[] nums, int target) {
        Arrays.sort(nums);
        // cannot use Arrays.sort(nums, (a, b) -> a - b); for int[], because int - int could be a issue for negative numbers - need to transfer from int[] to Integer[]
        // if want to do des order, Arrays.sort(nums, Collections.reverseOder());  - num is Integer[]
        int i = 0, j = nums.length - 1;
        int count = 0;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                i++;
                j--;
                count++;
                while (i < j && nums[i - 1] == nums[i] ) i++;
                while (i < j && nums[j] == nums[j + 1]) j--;
                System.out.println(i);
            }
            else if (nums[i] + nums[j] > target) {
                j--;
            }
            else {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TwoSumUniquePairs s = new TwoSumUniquePairs();
        int[] nums = {1, 1, 2, 45, 46, 46};
        System.out.println(s.twoSum6(nums, 47));
    }
}
