// lc 139 https://www.youtube.com/watch?v=ptlwluzeC1I&ab_channel=HuaHua
import java.util.*;
public class WordBreak {
    // DP time O(n^2) space O(n)   篮子王解法
    // // dp[i] means s.substring(0, i) is breakable, can be segmented with wordDict
    public boolean wordBreakDP(String s, List<String> wordDict) {
        if (s == null || wordDict == null) return false;
        Set<String> set = new HashSet<>();
        for (String str : wordDict) set.add(str);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = dp[i - j] && set.contains(s.substring(i - j, i));
                if (dp[i]) break;
            }
        }
        return dp[dp.length - 1];
    }

    // time O(n^2) space O(n)
    // dfs + memorization  花花解法
    static Map<String, Boolean> memo = new HashMap<>();
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);    
        }
        
        return wordBreakHelper(s, set);
    }
    public static boolean wordBreakHelper(String s, Set<String> set) {
        if (s.isEmpty()) return true;
        if (set.contains(s)) return true;
        if (memo.containsKey(s)) return memo.get(s);
        int l = s.length();
        for (int i = 1; i <= l; i++) {
            String leftSub = s.substring(0, i);
            String rightSub = s.substring(i);
            if (set.contains(leftSub)) {
                boolean rightRes = wordBreakHelper(rightSub, set);
                if (rightRes) {
                    return true;    
                }
                else {
                    memo.put(rightSub, false);
                }    
            }
        }
        return false;
    } 

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>(Arrays.asList("apple", "pen"));
        boolean res = wordBreak("applepenapple", wordDict);
        System.out.println(res);
    }
}
