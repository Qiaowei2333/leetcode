// lc 297 https://www.youtube.com/watch?v=JL4OjKV_pGE&t=38s
// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74253/Easy-to-understand-Java-Solution
import java.util.*;

public class SerializeandDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    private void traverse(TreeNode root, StringBuilder res) {
        if (root == null) {
            res.append("#").append(",");
            return;
        } 
        res.append(root.val + ",");
        traverse(root.left, res);
        traverse(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArr = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (String s : dataArr) queue.offer(s);
        TreeNode root = buildTree(queue);
        return root;
    }
    
    private TreeNode buildTree(Queue<String> queue) {
        if (queue.peek().equals("#")) {
            queue.poll();
            return null;
        }
        String s = queue.poll();
        TreeNode cur = new TreeNode(Integer.parseInt(s));
        cur.left = buildTree(queue);
        cur.right = buildTree(queue);
        return cur;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}