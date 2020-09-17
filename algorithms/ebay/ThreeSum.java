// lc 15
// tc O(n^2) sc O(n)
import java.util.*;
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int l = i + 1;
                int r = nums.length - 1;
                int target = -nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == target) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[l]);
                        triplet.add(nums[r]);
                        result.add(triplet);
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1]) l++;
                        while (l < r && nums[r] == nums[r + 1]) r--; 
                    }
                    else if (nums[l] + nums[r] > target) {
                        r--;
                    }
                    else {
                        l++;
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