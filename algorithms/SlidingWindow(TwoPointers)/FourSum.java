// lc 18
import java.util.*;
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4 || nums[0] + nums[1] + nums[2] + nums[3] > target || nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] + nums[nums.length - 4] < target) {
            return result;
        }
        for (int i = 0; i <= nums.length - 4; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j <= nums.length - 3; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1;
                int r = nums.length - 1;
                boolean dir = true;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum > target) {
                        r--;
                        dir = false;
                    }
                    else if (sum < target) {
                        l++;
                        dir = true;
                    }
                    else {
                        List<Integer> quadruplet = new ArrayList<>();
                        quadruplet.add(nums[i]);
                        quadruplet.add(nums[j]);
                        quadruplet.add(nums[l]);
                        quadruplet.add(nums[r]);
                        result.add(quadruplet);
                        if (dir) {
                            l++;
                            while (l < r && nums[l] == nums[l - 1]) { l++; }
                        }
                        else {
                            r--;
                            while (l < r && nums[r] == nums[r + 1]) { r--; }
                        }
                    }
                } 
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        FourSum s = new FourSum();
        List<List<Integer>> result = s.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        for (List<Integer> r : result) {
            System.out.println(r);
        }
    }
}
