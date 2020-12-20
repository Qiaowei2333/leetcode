// lc 113
import java.util.*;
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new LinkedList<>();
        traverse(root, sum, 0, list, res);
        return res;
    }
    
    private void traverse(TreeNode root, int target, int curSum, List<Integer> list, List<List<Integer>> res) {
        if (root == null) return;
        curSum += root.val;
        list.add(root.val);
        traverse(root.left, target, curSum, list, res);
        traverse(root.right, target, curSum, list, res);
        if (root.right == null && root.left == null) {
            if (curSum == target) {
                res.add(new ArrayList<>(list));
            }
        }
        curSum -= root.val;
        list.remove(list.size() - 1);
    } 
}
