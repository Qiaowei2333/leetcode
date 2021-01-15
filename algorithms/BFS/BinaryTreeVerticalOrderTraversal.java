// lc 314
import java.util.*;
public class BinaryTreeVerticalOrderTraversal {
    // bfs o（n） n-树里面有多少节点
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<State> queue = new LinkedList<>();
        int leftMst = 1; // 不设置为0， 为了避免输入为[]，给res加入null值
        int rightMst = -1;
        if(root != null) queue.offer(new State(root, 0));
        while (!queue.isEmpty()) {
            State cur = queue.poll();
            int key = cur.x;
            leftMst = Math.min(leftMst, key);
            rightMst = Math.max(rightMst, key);
            TreeNode newNode = cur.node;
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(newNode.val);
            
            if (newNode.left != null) queue.offer(new State(newNode.left, key - 1));
            if (newNode.right != null) queue.offer(new State(newNode.right, key + 1));
        }
        while (leftMst <= rightMst) {
            res.add(map.get(leftMst));
            leftMst++;
        }
        return res;
    }
    
    static class State {
        TreeNode node;
        int x;
        public State(TreeNode node, int x) {
            this.node = node;
            this.x = x;
        }
    }
}
