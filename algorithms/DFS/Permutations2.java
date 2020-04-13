// lc 47
import java.util.*;
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
            if (selected[i] || (i != 0 && nums[i] == nums[i - 1]) && selected[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            selected[i] = true;
            dfsHelper(nums, result, list, selected);
            list.remove(list.size() - 1);
            selected[i] = false;
        }
    }
}