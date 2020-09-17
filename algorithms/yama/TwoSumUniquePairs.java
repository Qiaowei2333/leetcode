// lin587
public class TwoSumUniquePairs {
    public int twoSum6(int[] nums, int target) {
        Arrays.sort(nums, (a, b) -> a - b);
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
}
