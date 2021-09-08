// lc 297 https://www.youtube.com/watch?v=JL4OjKV_pGE&t=38s
// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74253/Easy-to-understand-Java-Solution
// NOTES:
// 1. 比较string 用 equals
// 2. StringBuilder 可以 deleteCharAt,来remove last char
// 3. inorder postorder preorder,都可以serialize一个数，但是inorder无法deserialize回去
// 其实 postorder和preorder也是一样的，serialize出来的序列一模一样，只是顺序相反，所以deserialize本质也是一样的
// inorder出来的string为啥不可以deserialize，
//   1） 2 as the root and 1 as the right child
//   2） 1 as the root and 2 as the left child
// 这两个inorder顺序一样，但是是两个不同的数
// 4. 此题和lc 105类似，但是为啥lc 105需要两个顺序，因为105没有记录null，不知道叶子节点
import java.util.*;

public class SerializeandDeserializeBinaryTree {
    // sol1 preOrder
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
    // 这里不用queue，用linkedlist也行，每次removeFirst from list，和queue是一样的
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

    // Sol2 postOrder  serialize可以用postorder，但是其结果就是inorder的reverse
    // 所以本质上deserialize，都是一样的，只是postorder，要先右后左
    public String serialize2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverse2(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    private void traverse2(TreeNode root, StringBuilder res) {
        if (root == null) {
            res.append("#").append(",");
            return;
        } 
        traverse2(root.left, res);
        traverse2(root.right, res);  
        res.append(root.val + ",");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        String[] dataArr = data.split(",");
        Stack<String> stack = new Stack<>(); // 用stack的目的是因为postorder的string正好是preorder的反过来的顺序，用stack可以得到和preorder一样的顺序
        for (String s : dataArr) stack.push(s);
        TreeNode root = buildTree2(stack);
        return root;
    }
    
    private TreeNode buildTree2(Stack<String> stack) { // buildtree，preorder和postorder都是一样的，只是左右顺序不一样
        if (stack.peek().equals("#")) {
            stack.pop();
            return null;
        }
        String s = stack.pop();
        TreeNode cur = new TreeNode(Integer.parseInt(s));
        cur.right = buildTree2(stack);
        cur.left = buildTree2(stack);
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