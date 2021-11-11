// lc 1514
// 无向图， 有权值，权值>=0
import java.util.*;
public class PathWithMaximumProbability {
    // time O(eloge) e - number of edges
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<double[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double weight = succProb[i];
            graph.get(u).add(new double[]{v, weight});
            graph.get(v).add(new double[]{u, weight});
        }
        return dijkstra(start, end, graph, n);
    }
    
    private double dijkstra(int start, int end, List<List<double[]>> graph, int n) {
        double[] maxProbToStart = new double[n];
        Arrays.fill(maxProbToStart, Double.MIN_VALUE);
        maxProbToStart[start] = 1;
        
        Queue<State> pq = new PriorityQueue<>((a, b) -> Double.compare(b.maxProbToStart, a.maxProbToStart));
        pq.offer(new State(start, 1.0));
        
        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int oldId = cur.id;
            if (maxProbToStart[oldId] > cur.maxProbToStart) continue;
            
            if (oldId == end) {
                return cur.maxProbToStart;
            }
                
            List<double[]> nbs = graph.get(oldId);
            for (double[] nb : nbs) {
                int newId = (int) nb[0];
                double edge = nb[1];
                if (cur.maxProbToStart * edge > maxProbToStart[newId]) {
                    maxProbToStart[newId] = cur.maxProbToStart * edge;
                    pq.offer(new State(newId, maxProbToStart[newId]));
                }
            }
        }
        
        return 0;
    }
    static class State {
        int id;
        double maxProbToStart;
        public State(int id, double maxProbToStart) {
            this.id = id;
            this.maxProbToStart = maxProbToStart;
        }
    }
}


