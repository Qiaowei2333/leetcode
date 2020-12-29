// lc 269
import java.util.*;
class AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, Integer> indegree = new HashMap<>();
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (int i = 1; i < words.length; i++) {
            compare(words[i - 1], words[i], indegree, graph);
        }
        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Set<Character>> entry : graph.entrySet()) {
            if (!indegree.containsKey(entry.getKey())) queue.offer(entry.getKey());
        }
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            char cur = queue.poll();
            res.append(cur);
            for (char nb : graph.get(cur)) {
                indegree.put(nb, indegree.get(nb) - 1);
                if (indegree.get(nb) == 0) {
                    queue.offer(nb);
                }
            }
        }
        if (res.length() == graph.size()) {
            return res.toString();
        }
        else {
            return "";
        }
    }
    
    private void compare(String a, String b, Map<Character, Integer> indegree, Map<Character, Set<Character>> graph) {
        int i = 0;
        while (i < a.length() && i < b.length()) {
            if (a.charAt(i) != b.charAt(i)) {
                if (!graph.containsKey(a.charAt(i))) graph.put(a.charAt(i), new HashSet<>());
                if (!graph.containsKey(b.charAt(i))) graph.put(b.charAt(i), new HashSet<>());
                if (!graph.get(a.charAt(i)).contains(b.charAt(i))) indegree.put(b.charAt(i), indegree.getOrDefault(b.charAt(i), 0) + 1);
                graph.get(a.charAt(i)).add(b.charAt(i));
                break;
            }
            else {
                if (i == 0)
                    if (!graph.containsKey(a.charAt(i))) graph.put(a.charAt(i), new HashSet<>());
            }
            i++;
        }
    }

    public static void main(String[] args) {
        AlienDictionary s = new AlienDictionary();
        String[] words = {"wr","wr"};
        String res = s.alienOrder(words);
        System.out.println(res);
    }
}