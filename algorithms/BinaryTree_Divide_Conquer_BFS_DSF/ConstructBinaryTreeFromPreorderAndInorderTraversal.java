// lc 105 https://www.youtube.com/watch?v=6Xcz08RkRHE
import java.util.*;
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inmap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inmap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, 0, inorder.length - 1, inmap);
    }
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd, Map<Integer, Integer> inmap) {
        if (inStart > inEnd) return null;
        int val = preorder[preStart];
        TreeNode cur = new TreeNode(val);
        int inRoot = inmap.get(val);
        int numLeft = inRoot - inStart + 1;
        cur.left = buildTree(preorder, inorder, preStart + 1, inStart, inRoot - 1, inmap);
        cur.right = buildTree(preorder, inorder, preStart + numLeft, inRoot + 1, inEnd, inmap);
        return cur;
    }
}
