// lc 113
import java.util.*;
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        topDown(root, targetSum, list, res);
        return res;
    }
    
    private void topDown(TreeNode root, int targetSum, List<Integer> list, List<List<Integer>> res) {
        if (root == null) return;
        
        list.add(root.val);
        topDown(root.left, targetSum - root.val, list, res);
        topDown(root.right, targetSum - root.val, list, res);

        if (root.left == null && root.right == null && root.val == targetSum) {
            res.add(new ArrayList<>(list));
        }
        list.remove(list.size() - 1);
    }
}
