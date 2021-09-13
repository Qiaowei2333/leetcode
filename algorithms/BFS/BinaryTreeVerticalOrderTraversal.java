// lc 314
import java.util.*;
public class BinaryTreeVerticalOrderTraversal {
    // https://www.youtube.com/watch?v=0jRXoyfl99o&t=591s&ab_channel=AndroidBabies%E5%AE%89%E5%8D%93%E5%A4%A7%E5%AE%9D%E8%B4%9D%E4%BB%AC
    // 此题关键是如何获取并记录每个节点col的信息，可以以根为0，根左边的-1，右边的加1
    // 下面这个解法是先用dfs获取了每个node和col的对应信息，再用bfs level order traversal获取vertical order
    // 为啥dfs不能直接得到vertical order，因为dfs，假如是先左后右的顺序，同样column下，左边子树很靠右的点（depth = 3），会比右边子树的点（depth = 1）先加到result里面，
    // 无法按照depth的顺序加到result
    private int leftMst = 0;
    private int rightMst = 0;
    public List<List<Integer>> verticalOrderSol2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Map<TreeNode, Integer> map = new HashMap<>();
        preorderTraverse(root, map, 0);
        
        for (int i = leftMst; i <= rightMst; i++) {
            res.add(new ArrayList<>());
        }
        
        leverorderTraverse(root, map, res);
        return res;
    }
    
    private void preorderTraverse(TreeNode root, Map<TreeNode, Integer> map, int colNum) {
        if (root == null) return;
        
        map.put(root, colNum);
        
        leftMst = Math.min(leftMst, colNum);
        rightMst = Math.max(rightMst, colNum);
        
        preorderTraverse(root.left, map, colNum - 1);
        preorderTraverse(root.right, map, colNum + 1);
    }
    
    private void leverorderTraverse(TreeNode root, Map<TreeNode, Integer> map, List<List<Integer>> res) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                int col = map.get(cur) - leftMst;
                res.get(col).add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
    }

    // bfs o（n） n-树里面有多少节点
    // 这个解法和sol2类似，也是记录column信息，优点是没有dfs，直接是进入queue是就利用state class，来记录col的信息
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
