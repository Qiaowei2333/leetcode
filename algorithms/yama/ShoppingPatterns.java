// https://leetcode.com/discuss/interview-question/906481/
import java.util.*;
public class ShoppingPatterns {
    // time O(v + e)
    public static int getMinScoreVEComplexity(int product_nodes, int product_edges, List<Integer> products_from, List<Integer> products_to) {
        Map<Integer, Set<Integer>> edgeMap = new HashMap<>();
        for(int i=0; i < product_edges; i++) {
            int from = products_from.get(i);
            int to = products_to.get(i);
            
            if(!edgeMap.containsKey(from))
                edgeMap.put(from, new HashSet<>());
            if(!edgeMap.containsKey(to))
                edgeMap.put(to, new HashSet<>());
    
            edgeMap.get(from).add(to);
            edgeMap.get(to).add(from);						
        }
        int minScore = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Set<Integer>> edges : edgeMap.entrySet()) {
            Integer u = edges.getKey();
            Set<Integer> u_edges = edges.getValue();
            
            for(Integer v: u_edges) {
                Set<Integer> v_edges = edgeMap.get(v);
                if(v_edges.size() < 2) 
                    continue;
                for(Integer w: v_edges) {
                    if(w == u||w == v)
                        continue;
                    Set<Integer> w_edges = edgeMap.get(w);
                    if(w_edges.contains(u)) {
                        minScore = Math.min(minScore, u_edges.size() + v_edges.size() + w_edges.size() - 6);
                    }
                }
            }			
        }
        return minScore == Integer.MAX_VALUE ? -1: minScore;
    }

    public static void main(String[] args) {
        System.out.println(3 == getMinScoreVEComplexity(6, 6, Arrays.asList(1,2,2,3,4,5), Arrays.asList(2,4,5,5,5,6)) ? "Test 1 Passed" : "Test 1 failed");
        System.out.println(2 == getMinScoreVEComplexity(5, 6, Arrays.asList(1,1,2,2,3,4), Arrays.asList(2,3,3,4,4,5)) ? "Test 2 Passed" : "Test 2 failed");
    }
}
