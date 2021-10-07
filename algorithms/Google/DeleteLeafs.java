// https://www.1point3acres.com/bbs/thread-804623-1-1.html
// onsite 3轮coding + 1轮bq
// 第一题，每次删所有叶子节点，直到删完。 followup：每次删完叶子节点，对返回的叶子节点做permutation：
// e.g. 树是
//            1
//     2            3
// 那你应该返回(2 3 1) and (3 2 1)
//
// e.g.2：
//      1
// 2        3
//       4    5
// 输出应该是[2,4,5,3,1], [2,5,4,3,1], [4,2,5,3,1], [4,5,2,3,1], [5,2,4,3,1], [5,4,2,3,1]
//
// 每一次删除所有叶子结点，直到删除完（必须preorder，如果是其他oder可能把原本不是leaf的node删除），每次得到的叶子结点，可以做permutation，dfs+backtracking
import java.util.*;
public class DeleteLeafs {
    public List<List<Integer>> leafPermutation(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        TreeNode dummy = new TreeNode(-1);
        dummy.left = root;
        boolean first = true;
        while (dummy.left != null) {
            List<TreeNode> level = new ArrayList<>();
            deleteAllLeafs(root, dummy, true, level);
            List<List<Integer>> oneLevel = getPermutations(); // leetcode permutation and permutation2

            for (List<Integer> one : oneLevel) {
                for (List<Integer> prev : res) {
                    List<Integer> newAns = new ArrayList<>(prev);
                    newAns.addAll(one);
                }
            }
        }
        return res;
    }

    public void deleteAllLeafs(TreeNode root, TreeNode parent, boolean rootIsleftOfParent, List<TreeNode> res) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            res.add(root);
            if (rootIsleftOfParent) {
                parent.left = null;
            }
            else {
                parent.right = null;
            }
        }

        deleteAllLeafs(root.left, root, true, res);
        deleteAllLeafs(root.right, root, false, res);
    }

    public static void main(String[] args) {
        DeleteLeafs s = new DeleteLeafs();
        TreeNode dummy = new TreeNode(-1);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        dummy.left = n1;
        n1.left = n2;
        n1.right = n3;
        List<TreeNode> level = new ArrayList<>();
        s.deleteAllLeafs(n1, dummy, true, level);
        for (TreeNode l : level) {
            System.out.println(l.val);
        }
        level.clear();
        s.deleteAllLeafs(n1, dummy, true, level);
        for (TreeNode l : level) {
            System.out.println(l.val);
        }
    }


    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
