// leetcode 297 https://www.youtube.com/watch?v=JL4OjKV_pGE&t=38s
import java.util.*;

public class SerializeandDeserializeBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
    // use arraylist as queue, trim #s in the end
    // return {1,2,3,#,#,4,5}
    public String serialize1(TreeNode root) {
        if (root == null) {
            return "{}";
        }

        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);

        for (int i = 0; i < queue.size(); i++) {
            TreeNode cur = queue.get(i);
            if (cur == null) {
                continue;
            }
            queue.add(cur.left);
            queue.add(cur.right);
        }

        while (queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i) == null) {
                sb.append("#");
            } else {
                sb.append(queue.get(i).val);
            }

            sb.append(",");
        }
        sb.delete(queue.size() - 1, queue.size());
        return sb.toString();
    }
    // input {1,2,3,#,#,4,5}
    public TreeNode deserialize1(String data) {
        // write your code here
        if (data.equals("{}")) {
            return null;
        }

        String[] vals = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int index = 0;
        boolean isLeft = true;
        for (int i = 1; i < vals.length; i++) {
            String curVal = vals[i];
            if (!curVal.equals("#")) {
                TreeNode curNode = queue.get(index);
                if (isLeft) {
                    curNode.left = new TreeNode(Integer.parseInt(curVal));
                    queue.add(curNode.left);
                } else {
                    curNode.right = new TreeNode(Integer.parseInt(curVal));
                    queue.add(curNode.right);
                }
            }
            System.out.println(index);
            if (!isLeft) {
                index++;
            }
            isLeft = !isLeft;
        }
        return root;
    }
    
    // use queue
    // // return {1,2,3,#,#,4,5,#,#,#,#}
    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            if (head == null) {
                sb.append("#");
            } else {
                sb.append(head.val);
                queue.offer(head.left);
                queue.offer(head.right);
            }

            if (!queue.isEmpty()) {
                sb.append(",");
            }
        }
        sb.append("}");
        System.out.println(sb);
        return sb.toString();
    }
    
    // use linkedlist as queue
    // input string {1,2,3,#,#,4,5,#,#,#,#}
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("{}")) {
            return null;
        }

        String[] vals = data.substring(1, data.length() - 1).split(",");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.offer(root);
        boolean isLeftChild = true;
        for (int i = 1; i < vals.length; i++) {
            String curVal = vals[i];
            if (!curVal.equals("#")) {
                TreeNode child = new TreeNode(Integer.parseInt(curVal));
                if (isLeftChild) {
                    queue.peek().left = child;
                } else {
                    queue.peek().left = child;
                }
                queue.offer(child);
            }
            if (!isLeftChild) {
                queue.poll();
            }
            isLeftChild = !isLeftChild;
        }
        return root;
    }
}