// lc 889 此题与105， 106类似， 解法借鉴了 https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/discuss/161372/Java-Python-Divide-and-Conquer-with-Explanation
// 不同之处在与 construct binary tree用 preorder + inorder，或者 postorder + inorder，都可以唯一确定一个树，但是 用postorder和preorder有时无法唯一确定树
// 例如:
//   1    1
//  /      \
// 2        2
// 这两个树的postorder和preorder是一样的

import java.util.*;
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    // time O(n)， space O（n）
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> postMap = new HashMap<>();
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            postMap.put(postorder[i], i);
        }
        return constructHelper(preorder, postorder, postMap, 0, n - 1, 0, n - 1);
    }
    
    // 实际不需要这么多参数 如果是用 preStart， preEnd来判断递归结束条件， 那么postEnd可以去掉，
    // 反之如果是用 postStart，postEnd判断， 则preEnd可以去掉
    private TreeNode constructHelper(int[] preorder, int[] postorder, Map<Integer, Integer> postMap, int preStart, int preEnd, int postStart, int postEnd) { 
        // 此时换成 postStart > postEnd，也可以
        if (preStart > preEnd) 
            return null;

        // 此时换成  postStart == postEnd， 也可以
        if (preStart == preEnd) return new TreeNode(preorder[preStart]); 
        
        int val = preorder[preStart];
        TreeNode curRoot = new TreeNode(val);
        
        int nextVal = preorder[preStart + 1];
        int postIdx = postMap.get(nextVal);
        
        int leftLen = postIdx - postStart + 1;
        
        curRoot.left = constructHelper(preorder, postorder, postMap, preStart + 1, preStart + leftLen, postStart, postIdx);
        
        curRoot.right = constructHelper(preorder, postorder, postMap, preStart + leftLen + 1, preEnd, postIdx + 1, postEnd - 1);
        
        return curRoot;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{1,2};
        int[] postorder = new int[]{2,1};

        ConstructBinaryTreeFromPreorderAndPostorderTraversal s = new ConstructBinaryTreeFromPreorderAndPostorderTraversal();
        TreeNode res = s.constructFromPrePost(preorder, postorder);
        System.out.println(res);
    }
}






