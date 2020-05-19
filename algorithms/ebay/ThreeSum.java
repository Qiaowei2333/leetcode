// lc 15
// tc O(n^2) sc O(n)
import java.util.*;
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                int low = i + 1;
                int high = nums.length - 1;
                int target = -nums[i];
                while (low < high) {
                    if (nums[low] + nums[high] == target) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[low]);
                        triplet.add(nums[high]);
                        result.add(triplet);
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    }
                    else if (nums[low] + nums[high] > target) {
                        high--;
                    } 
                    else {
                        low++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        // ThreeSum s = new ThreeSum();
        // List<List<Integer>> result = s.threeSum(new int[]{1, 2, 3});
        // System.out.println(result);
        System.out.println(Character.isLetter('#'));
        System.out.println(Character.isLetter('5'));
    }
}