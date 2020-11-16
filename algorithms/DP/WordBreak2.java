// lc 140
import java.util.*;
public class WordBreak2 {
    // dfs + memo time O(2^n)
    // 为啥要用memo， 思考例子 s = “abcedf”  wordDict = {"a", "b", "ab", "cd", "ef", "cdef"}
    // a,b, cedf
    // ab, cedf  如果不记录， cedf就要算两次
    public static List<String> wordBreakDFS(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for (String word : wordDict) dict.add(word);
        Map<String, List<String>> memo = new HashMap<>();
        List<String> res = dfsHelper(s, dict, memo);
        return res;
    }

    private static List<String> dfsHelper(String s, Set<String> dict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) return memo.get(s);
        if (s.equals("")) return null; // dont return new ArrayList<>(), 返回null，代表前面的substring还是在dict里面的，可以加到res里面， 返回new ArrayList<>(), 会和后面的一个情况混淆，就是没有res的情况，s is not breakable的情况
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            String leftStr = s.substring(0, i);
            String rightStr = s.substring(i);
            if (dict.contains(leftStr)) {
                List<String> rightRes = dfsHelper(rightStr, dict, memo);
                if (rightRes != null ) {
                    for (String str : rightRes) {
                        res.add(leftStr + " " + str);
                    }
                }
                else {
                    res.add(leftStr);
                }
            }
        }
        memo.put(s, res);
        return res;
    }

    // time O(2^n)
    // memory limit exceed in leetcode, sol https://leetcode.com/problems/word-break-ii/discuss/44185/Getting-rid-of-TLE
    public static List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null) return null;
        Set<String> set = new HashSet<>();
        for (String str : wordDict) set.add(str);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        List<String>[] listArr = new List[s.length() + 1];
        for (int i = 0; i < listArr.length; i++) {
            listArr[i] = new ArrayList<>();
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= i; j++) {
                String leftStr = s.substring(i - j, i);
                if (dp[i - j] && set.contains(leftStr)) {
                    dp[i] = true;
                    if (i != j) {
                        for (String str : listArr[i - j]) 
                            listArr[i].add(str + " " + leftStr);
                    }
                    else {
                        listArr[i].add(leftStr);
                    }
                }
            }
        }
        return listArr[listArr.length - 1];
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>(Arrays.asList("a", "b", "ab", "cd", "ef", "cdef"));
        String s = "abcdef";
        List<String> res = wordBreakDFS(s, wordDict);
        System.out.println(res);
    }
}
