// lc 285
public class InorderSuccessorInBST {
    // SOL 1 inorder traversal O(n)， 这个方法不好，看sol2和sol3
    private TreeNode prev;
    private TreeNode res;

    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        traverse(root, p);
        return res;
    }

    private void traverse(TreeNode root, TreeNode p) {
        if (root == null || res != null) return; // 加上res ！= null，会让剩下的遍历提前返回
        traverse(root.left, p);
        if (prev == p && res == null) {// 加上 res == null 保证这里只会执行一次
            res = root;
            return;
        }
        prev = root;
        traverse(root.right, p);
    }

    // sol 2 O(h) h is logN, height of the tree
    //To find a successor, you just need to find the smallest one that is larger than the given value since there are no duplicate values in a BST.
    //https://leetcode.com/problems/inorder-successor-in-bst/discuss/72656/JavaPython-solution-O(h)-time-and-O(1)-space-iterative
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while (root != null) {
            if (root.val > p.val) {
                succ = root;
                root = root.left;
            }
            else { // root.val <= p.val
                root = root.right;
            } 
        }
        return succ;
    }

    // sol 3 其实是sol2的recursion 写法 O(h)
    public TreeNode inorderSuccessor3(TreeNode root, TreeNode p) {// find first element > p
        if (root == null) return null;
        
        if (root.val <= p.val)
            return inorderSuccessor(root.right, p); // 如果当前小于等于p.val,往右走
        
        else { // root.val > p.val     如果当前大于p.val, 往左走
            TreeNode left = inorderSuccessor(root.left, p);
            if (left == null) {
                return root;
            }
            else {
                return left;
            }
        }
    }
}
