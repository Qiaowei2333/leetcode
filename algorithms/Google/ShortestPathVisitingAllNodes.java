// lc 847
// first comment in this link https://leetcode.com/problems/shortest-path-visiting-all-nodes/discuss/135809/Fast-BFS-Solution-(46ms)-Clear-Detailed-Explanation-Included
import java.util.*;
public class ShortestPathVisitingAllNodes {
    // time - O(n * 2 ^ n) n 是 number of nodes， 因为 每个node为起点，最多可能有2^n个状态，因为你的state（mask）是由n位组成的
    // https://www.youtube.com/watch?v=Vo3OEN2xgwk&t=435s&ab_channel=HuaHua
    // 原理花花讲的很清楚
    // https://www.youtube.com/watch?v=Gbiu-elcFps&ab_channel=AlgorithmsforBigBucks 代码这个python写的很清楚 bfs level order traversal 
    // 难点就是状态，不仅仅是一个 node，而是 node （0， 1， 2， ... ， n - 1） + 以该node为起点走过的node （0001）遍历过0 （0011）遍历过 0，1  （0111）遍历过0，1，2  （1111）最终目标0，1，2，3全遍历了
    // 用sting 来表示状态，方便找重复的
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int fullMask = (1 << n) - 1;
        
        Set<String> visited = new HashSet<>();
        Queue<Node> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Node node = new Node(i, 1<<i);
            que.offer(node);
            visited.add(node.toString());
        }
        
        int level = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Node node = que.poll();
                if (node.mask == fullMask) return level;
                for (int next : graph[node.id]) {
                    Node nextNode = new Node(next, node.mask | (1 << next));
                    if (visited.contains(nextNode.toString())) continue;
                    que.offer(nextNode);
                    visited.add(nextNode.toString());
                }
            }
            level++;
        }
        
        return level;
    }
    
    class Node {
        int id;
        int mask;
        
        Node(int id, int mask){
            this.id = id; this.mask = mask;
        }
        
        public String toString() {
            return id + " " + mask;
        }
    }

    public static void main(String[] args) {
        // 1 << 0 = 0001 = 1
        // 1 << 1 = 0010 = 2
        // 1 << 2 = 0100 = 4
        // 1 << 3 = 1000 = 8
        ShortestPathVisitingAllNodes s = new ShortestPathVisitingAllNodes();
        int fullMask = (1 << 0) - 1;
        System.out.println(fullMask);
    }
}
