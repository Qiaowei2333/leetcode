//lint 95
import java.util.*;

public class ValidateBinarySearchTreeTraverse {
    //  这个解法比divide & conquer好
    long prev;
    boolean res = true;
    public boolean isValidBST(TreeNode root) {
        prev = Long.MIN_VALUE; // 防止 root.val == Integer.MIN_VALUE
        inorderTraverse(root);
        return res;
    }
    
    private void inorderTraverse(TreeNode root) {
        if (root == null || res == false) return; // res 变成 false之后，遍历就可以结束了
        
        inorderTraverse(root.left);
        
        if (prev != Long.MIN_VALUE && prev >= (long) root.val) {
            res = false;
        }
        prev = (long) root.val;
        
        inorderTraverse(root.right);
    }
}