// lc 652
// https://www.youtube.com/watch?v=JLK92dbTt8k&ab_channel=HuaHua
// huahua: 每个节点确实只访问了一次，但是处理每个节点的时间是O(i), i是该节点所有子节点的数量，因为字符串拼接是线性时间。
// 对于根结点，key的长度是O(n)。对于perfect tree (best case)，相当于 T(n) = O(n) + 2T(n/2) = O(nlogn)。
// worst case 就是每个节点只有左子树, T(n) = O(n) + T(n-1) = O(n^2)。
import java.util.*;
public class FindDuplicateSubtrees {
    // time O(n^2)
    // 注意 这里用postorder是因为只有左右都遍历过了，才能确定当前root的string
    // 不然假如右边没走 怎么知道右边是什么，更不能确定是不是有一样的树了
    // 还有题目说的是for each kind of duplicate subtrees，所以要用map记录同样的subtree出现了几次
    // 只有map记录的频率等于2时才放入res，不需要放重复的，因为是each kind
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        postOrder(root, map, res);
        return res;
    }
    
    private String postOrder(TreeNode root, Map<String, Integer> map, List<TreeNode> res) {
        if (root == null) return "N,";
        String left = postOrder(root.left, map, res);
        String right = postOrder(root.right, map, res);
        String cur = left + right + root.val + ",";
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        if (map.get(cur) == 2) {
            res.add(root);
        }
        return cur;
    }
    // O(n) 优化就是不实用字符串拼接，使用long，int，参考花花酱
}
