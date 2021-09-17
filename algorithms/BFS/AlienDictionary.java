// lc 269, 是排所有出现过的letter的序
import java.util.*;
class AlienDictionary {
    // time O(n) n - total number of characters in words
    // space O(1) 我觉得趋近于常数 因为最多26个character
    // 注意有环的cornor case ["z","x","a","zb","zx"]， ["z","x","z"]， ["zxa","zx"]
    // 为什么最后要比较res.length和map.size()是否相等 line 30，注意第一个cornor case，本来是返回空string的，但是如果不比较，会返回"b"
    // 注意第三个conor case，根本构不成图，所以在构图是要检查最后的长度 line 58
    public String alienOrder(String[] words) {
        Map<Character, Integer> indegree = new HashMap<>();
        Map<Character, Set<Character>> graph = new HashMap<>(); // 为什么必须是set，不能是list，因为为了计算入度 line 53，必须先检查是否之前已经出现过了
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
                    if (!graph.get(a.charAt(i)).contains(b.charAt(i))) 
                        indegree.put(b.charAt(i), indegree.getOrDefault(b.charAt(i), 0) + 1);
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