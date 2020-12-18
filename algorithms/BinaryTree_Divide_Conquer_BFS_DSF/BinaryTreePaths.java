// lc 257
import java.util.*;
public class BinaryTreePaths {
    // divide and conquer  time O(nlogn) post order
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        List<String> cur = new ArrayList<>();
        for (String s : left) {
            cur.add(root.val + "->" + s);
        }
        for (String s : right) {
            cur.add(root.val + "->" + s);
        }
        if (left.size() == 0 && right.size() == 0) cur.add(root.val + "");
        return cur;
    }

    // traverse time O(n) preorder
    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> res = new ArrayList<>();
        traverse(root, res, "");
        return res;
    }
    
    private void traverse(TreeNode root, List<String> res, String path) {
        if (root == null) return;
        
        if (path.equals("")) {
            path += root.val;
        }
        else {
            path = path + "->" + root.val;
        }
        
        if (root.left == null && root.right == null) {
            res.add(path);
        }
        
        traverse(root.left, res, path);
        traverse(root.right, res, path);
    }
}
