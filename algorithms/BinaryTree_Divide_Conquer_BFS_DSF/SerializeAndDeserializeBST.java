// lc 449
import java.util.*;
public class SerializeAndDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    private void traverse(TreeNode root, StringBuilder res) {
        if (root == null) {
            return;
        } 
        res.append(root.val + ",");
        traverse(root.left, res);
        traverse(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] dataArr = data.split(",");
        System.out.println(Arrays.toString(dataArr));
        Queue<String> queue = new LinkedList<>();
        for (String s : dataArr) queue.offer(s);
        TreeNode root = buildTree(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return root;
    }
    
    private TreeNode buildTree(Queue<String> queue, int lowerB, int upperB) {
        if (queue.isEmpty()) {
            return null;
        }
        String s = queue.peek();
        int val = Integer.parseInt(s);
        if (val <= lowerB || val >= upperB) return null;
        TreeNode cur = new TreeNode(val);
        queue.poll();
        cur.left = buildTree(queue, lowerB, cur.val);
        cur.right = buildTree(queue, cur.val, upperB);
        return cur;
    }
}
