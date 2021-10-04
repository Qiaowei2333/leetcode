import java.util.*;
// lc 1048, 复习的时候看dfs -> dfs + memo
public class LongestStringChain {
    // time O(n*s*s) n - number of word in words, s - avg length of word
    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, (a, b)->a.length() - b.length());
        int res = 0;
        for (String word : words) {
            int best = 0;
            for (int i = 0; i < word.length(); ++i) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, best);
            res = Math.max(res, best);
        }
        return res;
    }

    // DFS 会超时
    public int longestStrChainDFS(String[] words) {
        int ans = 0;
        Set<String> set = new HashSet<>();
        for(String word : words) {
            set.add(word);
        }
        for(String word : words) 
            ans = Math.max(ans, helper(set, word));
        return ans;
    }
    
    private int helper(Set<String> set, String word){
        int max = 1;
        for (int i = 0; i < word.length(); i++) {
            String prev = word.substring(0, i) + word.substring(i + 1);
            if (set.contains(prev)) {
                max = Math.max(max, helper(set, prev) + 1);
            }
        }
        return max;
    }


    // dfs + memo  time O(n*s*s)
    public int longestStrChainDFSMemo(String[] words) {
        int ans = 0;
        Set<String> set = new HashSet<>();
        Map<String, Integer> dp = new HashMap<>();
        for(String word : words) {
            set.add(word);
        }
        for(String word : words) 
            ans = Math.max(ans, helper(set, word, dp));
        return ans;
    }
    
    private int helper(Set<String> set, String word, Map<String, Integer> dp){
        if (dp.containsKey(word)) return dp.get(word);
        int max = 1;
        for (int i = 0; i < word.length(); i++) {
            String prev = word.substring(0, i) + word.substring(i + 1);
            if (set.contains(prev)) {
                max = Math.max(max, helper(set, prev, dp) + 1);
            }
        }
        dp.put(word, max);
        return max;
    }
}
