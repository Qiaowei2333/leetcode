// lc 47
import java.util.*;
// 1. 难点在 line 29
// if (i != 0 && nums[i] == nums[i - 1] && selected[i - 1]) {
//   continue;
// }
public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        boolean[] selected = new boolean[nums.length];
        dfsHelper(nums, result, list, selected);
        return result;
    }
    
       private void dfsHelper(int[] nums, List<List<Integer>> result, List<Integer> list, boolean[] selected) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (selected[i]) {
                continue;
            }
            if ((i != 0 && nums[i] == nums[i - 1]) && !selected[i - 1]) {
                //The difficulty is to handle the duplicates.
                // With inputs as [1a, 1b, 2a],
                // If we don't handle the duplicates, the results would be: [1a, 1b, 2a], [1b, 1a, 2a]...,
                // so we must make sure 1a goes before 1b to avoid duplicates
                // By using nums[i-1]==nums[i] && !used[i-1], we can make sure that 1b cannot be choosed before 1a
                continue;
            }
            list.add(nums[i]);
            selected[i] = true;
            dfsHelper(nums, result, list, selected);
            list.remove(list.size() - 1);
            selected[i] = false;
        }
    }

    public static void main(String[] args) {
        Permutations2 s = new Permutations2();
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = s.permuteUnique(nums);
        System.out.println(result);
    }
}