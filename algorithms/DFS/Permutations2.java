// lc 47
import java.util.*;
// 1. 难点在 line 26
// if (i != 0 && nums[i] == nums[i - 1] && selected[i - 1]) {
//   continue;
// }
// 如果不是第一个点，并且i与i-1的值相等，而且前面的已经被选过了， 比如2，1，1  假如i=2，i=1的已经被选过了，那么重复的i=2不可以被选
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
            if ((i != 0 && nums[i] == nums[i - 1]) && selected[i - 1]) {
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
        int[] nums = {1, 1, 1};
        List<List<Integer>> result = s.permuteUnique(nums);
        System.out.println(result);
    }
}