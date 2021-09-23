// lc 46
import java.util.*;
public class Permutations {
    // time O(n * n!)
    // N + N*(N-1) + N*(N-1)*(N-2) + ... + N!
    // recursion tree一共n层，第一层n个节点，最后一层的叶子结点是n！个
    // 搜索树一共有 n!+n!2!+n!3!+…=n!(1+12!+13!+…)≤n!(1+12+14+18+…)=2n!n!+n!2!+n!3!+…=n!(1+12!+13!+…)≤n!(1+12+14+18+…)=2n! 个内部节点，
    // 在每个内部节点内均会for循环 n 次，因此内部节点的计算量也是 O(n×n!)。 
    // 所以总时间复杂度是 O(n×n!)O(n×n!)。
    // https://www.acwing.com/solution/leetcode/content/124/
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
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