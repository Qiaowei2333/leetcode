import java.util.*;
// array nums, find all number nums[j] - nums[i] <= k 
// this is related to lc 1169. Invalid Transactions
public class TwoDeductionLessThanK {
    public Set<Integer> findNumberInvalid(int[] nums, int k) {
        // Integer[] input = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        // Arrays.sort(input, (a, b) -> a - b);
        Integer[] nums2 = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i];
        }

        Arrays.sort(nums2, (a, b) -> a - b);


        Set<Integer> set = new HashSet<>();
        int left = 0;
        int right = 1;
        while (right < nums2.length) {
            int diff = nums2[right] - nums2[left];
            if (diff <= k) {
                if (right != left) {
                    set.add(nums2[left]);
                    set.add(nums2[right]);
                }
                right++;
            } 
            else {
                left++;
            }
        }
        return set;
    }

    public static void main(String[] args) {
        TwoDeductionLessThanK s = new TwoDeductionLessThanK();
        int[] nums = {1, 1, 3, 5};
        Set<Integer> result = s.findNumberInvalid(nums, 1);
        System.out.println(result);
    }
}