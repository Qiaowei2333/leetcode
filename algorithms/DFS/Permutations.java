// lc 46
import java.util.*;
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        dfsHelper(nums, result, list, set);
        return result;
    }
    
    private void dfsHelper(int[] nums, List<List<Integer>> result, List<Integer> list, Set<Integer> set) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            set.add(nums[i]);
            dfsHelper(nums, result, list, set);
            list.remove(list.size() - 1);
            set.remove(nums[i]);
        }
    }
}