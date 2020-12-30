// lc 269, 是排所有出现过的letter的序
import java.util.*;
class AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, Integer> indegree = new HashMap<>();
        Map<Character, Set<Character>> graph = new HashMap<>();
        if (!buildGraph(graph, indegree, words)) {
            return "";
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

    private boolean buildGraph(Map<Character, Set<Character>> graph, Map<Character, Integer> indegree, String[] words) {
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                graph.putIfAbsent(ch, new HashSet<>());
            }
        }

        for (int j = 1; j < words.length; j++) {
            String a = words[j - 1];
            String b = words[j];
            int i = 0;
            int minLen = Math.min(a.length(), b.length());
            while (i < minLen) {
                if (a.charAt(i) != b.charAt(i)) {
                    if (!graph.get(a.charAt(i)).contains(b.charAt(i))) indegree.put(b.charAt(i), indegree.getOrDefault(b.charAt(i), 0) + 1);
                    graph.get(a.charAt(i)).add(b.charAt(i));
                    break;
                }
                i++;
                if (i == minLen && a.length() > b.length()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        AlienDictionary s = new AlienDictionary();
        String[] words = {"abc","ab"};
        String res = s.alienOrder(words);
        System.out.println(res);
    }
}