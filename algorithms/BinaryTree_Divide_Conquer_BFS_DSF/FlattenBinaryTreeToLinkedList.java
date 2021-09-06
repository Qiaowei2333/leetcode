// lc 114
import java.util.*;
public class FlattenBinaryTreeToLinkedList {
    // Best solution - time O(n), space O(1) 
    // 右左根遍历，利用prev，反向联起来，就是根左右的顺序
    private TreeNode pre = null;
    public void flatten1(TreeNode root) {
        if (root == null) return;
        flatten1(root.right);
        flatten1(root.left);
        // System.out.println(root.val);
        root.right = pre;
        root.left = null;
        pre = root;
    }

    // 上一个解法是利用右左根的遍历，这个是右左根的stack的解法
    // 右左根实际上就是根左右反过来 result.add(0, cur.val)
    // 所以这里实际上写的是preorder遍历
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            
            // result.add(0, cur.val); 此时 result是右左根
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null ) stack.push(cur.left);
            
            cur.left = null;
            // System.out.println(cur.val);
            if (!stack.isEmpty()) cur.right = stack.peek();
        }
    }


    
    static class PairMinMax {
        TreeNode min;
        TreeNode max;
    }
}
