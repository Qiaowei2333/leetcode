// https://zhuanlan.zhihu.com/p/409121513
// 二叉树level order bfs 模版
// 多叉树level order bfs 模版
// general 的 bfs 模版
// Dijkstra的模版
import java.util.*;

public class BFSTemplate {
    void levelTraverseBinaryTree(Node root) {
        if (root == null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            // 从左到右遍历每一层的每个节点
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                printf("节点 %s 在第 %s 层", cur, depth);
    
                // 将下一层节点放入队列
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            depth++;
        }
    }

    void levelTraversePolyTree(Node root) {
        if (root == null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
    
        int depth = 1;
        // 从上到下遍历多叉树的每一层
        while (!q.isEmpty()) {
            int sz = q.size();
            // 从左到右遍历每一层的每个节点
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                printf("节点 %s 在第 %s 层", cur, depth);
    
                // 将下一层节点放入队列
                for (Node child : cur.children) {
                    q.offer(child);
                }
            }
            depth++;
        }
    }

    // 输入起点，进行 BFS 搜索
    int generalBFS(Node start) {
        Queue<Node> q; // 核心数据结构
        Set<Node> visited; // 避免走回头路

        q.offer(start); // 将起点加入队列
        visited.add(start);

        int step = 0; // 记录搜索的步数
        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散一步 */
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                printf("从 %s 到 %s 的最短距离是 %s", start, cur, step);

                /* 将 cur 的相邻节点加入队列 */
                for (Node x : cur.adj()) {
                    if (x not in visited) {
                        q.offer(x);
                        visited.add(x);
                    }
                }
            }
            step++;
        }
    }


    static class Node {
        int val;
        Node left;
        Node right;
        public Node(int x) {
            val = x;
        }
    }


    ////////Dijkstra模版 所有weight都必须>=0 time complexity O(ElogE) 为什么是logE,因为优先队列里面可能会有重复的点，最多可能和edge的数目正相关
    // 返回节点 from 到节点 to 之间的边的权重
    int weight(int from, int to);

    // 输入节点 s 返回 s 的相邻节点
    List<Integer> adj(int s);

    // 输入一幅图和一个起点 start，计算 start 到其他节点的最短距离
    int[] dijkstra(int start, List<Integer>[] graph) {
        // 图中节点的个数
        int V = graph.length;
        // 记录最短路径的权重，你可以理解为 dp table
        // 定义：distTo[i] 的值就是节点 start 到达节点 i 的最短路径权重
        int[] distTo = new int[V];
        // 求最小值，所以 dp table 初始化为正无穷
        Arrays.fill(distTo, Integer.MAX_VALUE);
        // base case，start 到 start 的最短距离就是 0
        distTo[start] = 0;

        // 优先级队列，distFromStart 较小的排在前面
        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.distFromStart - b.distFromStart;
        });

        // 从起点 start 开始进行 BFS
        pq.offer(new State(start, 0));

        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curNodeID = curState.id;
            int curDistFromStart = curState.distFromStart;

            if (curDistFromStart > distTo[curNodeID]) {
                // 已经有一条更短的路径到达 curNode 节点了
                continue;
            }
            // 将 curNode 的相邻节点装入队列
            for (int nextNodeID : adj(curNodeID)) {
                // 看看从 curNode 达到 nextNode 的距离是否会更短
                int distToNextNode = distTo[curNodeID] + weight(curNodeID, nextNodeID);
                if (distTo[nextNodeID] > distToNextNode) {
                    // 更新 dp table
                    distTo[nextNodeID] = distToNextNode;
                    // 将这个节点以及距离放入队列
                    pq.offer(new State(nextNodeID, distToNextNode));
                }
            }
        }
        return distTo;
    }

    static class State {
        // 图节点的 id
        int id;
        // 从 start 节点到当前节点的距离
        int distFromStart;
    
        State(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }
}
