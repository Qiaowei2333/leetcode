// lc 106  lc 105类似，就是要把inorder和postorder reverse一下
import java.util.*;
public class ConstructBinaryTreefromInorderAndPostorderTraversal {
    // lc 105 根左右 左根右， 关键就是找到根就能划分左右， 这道题是找到根划分右左
    // post顺序 反过来就是 根右左的顺序
    // inorder顺序反过来是 右根左的顺序
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int a = 0, b = postorder.length - 1;
        while (a < b) {
            int temp = postorder[a];
            postorder[a] = postorder[b];
            postorder[b] = temp;
            int temp2 = inorder[a];
            inorder[a] = inorder[b];
            inorder[b] = temp2;
            a++;
            b--;
        }
        Map<Integer, Integer> inmap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inmap.put(inorder[i], i);
        }
        return buildTree(postorder, inorder, 0, 0, inorder.length - 1, inmap);
    }
    
    private TreeNode buildTree(int[] postorder, int[] inorder, int preStart, int inStart, int inEnd, Map<Integer, Integer> inmap) {
        if (inStart > inEnd) return null;
        int val = postorder[preStart];
        TreeNode cur = new TreeNode(val);
        int inRoot = inmap.get(val);
        int numLeft = inRoot - inStart + 1;
        cur.right = buildTree(postorder, inorder, preStart + 1, inStart, inRoot - 1, inmap);
        cur.left = buildTree(postorder, inorder, preStart + numLeft, inRoot + 1, inEnd, inmap);
        return cur;
    }
}
