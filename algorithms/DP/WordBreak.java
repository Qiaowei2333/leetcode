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
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dic = new HashSet<>();
        Map<String, Boolean> mem = new HashMap<>();
        for (String word : wordDict) dic.add(word); 
        return helper(s, dic, mem);
    }

    private static boolean helper(String s, Set<String> dic, Map<String, Boolean> mem) {
        if (mem.containsKey(s)) return mem.get(s);
        if (dic.contains(s)) return true;
        if (s.length() == 1) {
            if (dic.contains(s)) return true;
            else return false;
        }
        for (int i = 1; i < s.length(); i++) {
            String leftStr = s.substring(0, i);
            String rightStr = s.substring(i);
            boolean left = helper(leftStr, dic, mem);
            mem.put(leftStr, left);
            boolean right = dic.contains(rightStr);
            if (left && right) return true; 
        }
        return false;
    } 

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>(Arrays.asList("apple", "pen"));
        boolean res = wordBreak("applepenapple", wordDict);
        System.out.println(res);
    }
}
