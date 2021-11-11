// lc 743
// 有相图，有权值，权值>=0
import java.util.*;
public class NetworkDelayTime {
    // time O(eloge) e - number of edges
    // 可能会有e个结点存在队列中
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] time : times) {
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        int[] distTo = dijkstra(k, graph);
        
        int res = -1;

        for (int i = 1; i <= n; i++) {
            if (i == k) continue;
            if (distTo[i] == Integer.MAX_VALUE) {
                res = -1;
                break;
            }
            res = Math.max(res, distTo[i]);
        }
        return res;
    }

    private int[] dijkstra(int start, Map<Integer, List<int[]>> graph) {
        int[] distTo = new int[graph.size() + 1];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[start] = 0;

        Queue<State> pq = new PriorityQueue<>((a, b) -> a.distFromStart - b.distFromStart);
        pq.offer(new State(start, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            if (cur.distFromStart > distTo[cur.id]) continue;
            List<int[]> nbs = graph.get(cur.id);
            for (int[] nb : nbs) {
                if (cur.distFromStart + nb[1] < distTo[nb[0]]) {
                    distTo[nb[0]] = cur.distFromStart + nb[1];
                    // prev[nb.id] = cur.id;
                    pq.offer(new State(nb[0], distTo[nb[0]]));
                }
            }
        }
        return distTo;
    }

    public static void main(String[] args) {
        NetworkDelayTime s = new NetworkDelayTime();
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int res = s.networkDelayTime(times, 4, 2);
        System.out.println(res);
    }

    static class State {
        int id;
        int distFromStart;
        public State(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }
}


