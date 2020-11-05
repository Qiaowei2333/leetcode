// https://leetcode.com/discuss/interview-question/782606/
// lc 323 similar
import java.util.*;
public class LargestItemAssociation {
    // time O(v*e*loge + k * log k) e: edges, v: vertex, k: # of connected components
    // space o(v + e)
	public List<String> largestItemAssociation(List<PairString> itemAssociation) {
        // write your code here
        List<List<String>> resPool = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>();
        for (PairString p : itemAssociation) {
            if (!graph.containsKey(p.first)) graph.put(p.first, new ArrayList<>());
            if (!graph.containsKey(p.second)) graph.put(p.second, new ArrayList<>());
            graph.get(p.first).add(p.second);
            graph.get(p.second).add(p.first);
        }
        Set<String> visited = new HashSet<>();
        for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
            String v = entry.getKey();
            List<String> list = new ArrayList<>();
            dfs(v, graph, visited, list);
            if (!list.isEmpty()) {
                Collections.sort(list);
                resPool.add(list);
            }
        }

        Collections.sort(resPool, (a, b) -> {
            if (a.size() != b.size()) {
                return b.size() - a.size();
            } 
            else {
                for (int i = 0; i < a.size(); i++) {
                    if (a.get(i).equals(b.get(i))) {
                        continue;
                    }
                    else {
                        return a.get(i).compareTo(b.get(i));
                    }
                }
                return 0;
            }
        });

        return resPool.get(0);
	}

    private void dfs(String v, Map<String, List<String>> graph, Set<String> visited, List<String> list) {
        if (visited.contains(v)) {
            return;
        }
        visited.add(v);
        list.add(v);
        for (String neighbor : graph.get(v)) {
            dfs(neighbor, graph, visited, list);
        }
    }

    static class PairString {
        String first;
        String second;
    
        public PairString(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }
    
    public static void main(String[] args) {
        LargestItemAssociation s = new LargestItemAssociation();
        List<PairString> itemAssociation = new ArrayList<>();
        itemAssociation.add(new PairString("item1", "item2"));
        itemAssociation.add(new PairString("item3", "item4"));
        itemAssociation.add(new PairString("item4", "item5"));
        List<String> res = s.largestItemAssociation(itemAssociation);
        System.out.println(res);
    }
}
