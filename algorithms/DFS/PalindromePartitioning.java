// lc 131
import java.util.*;
// 1. string s.substring
// 2. String curStr = s.substring(startPos, i + 1);
public class PalindromePartitioning {
    // sol1 time O(n * 2^n)
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        List<String> list = new ArrayList<>();
        helper(s, list, 0, result);
        return result;
    }
    
    private void helper(String s, List<String> list, int startPos, List<List<String>> result) {// 含义 对于 string s，从 startpos开始，得到之后所有的回文串的分裂组
        if (startPos == s.length()) {
            result.add(new ArrayList<String>(list));
            return;
        }
        for (int i = startPos; i < s.length(); i++) {
            String curStr = s.substring(startPos, i + 1);
            if (!isPalindrome(curStr)) {
                continue;
            }
            list.add(curStr);
            helper(s, list, i + 1, result);
            list.remove(list.size() - 1);
        }
    }
    
    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    // sol2 dp + dfs https://leetcode.com/problems/palindrome-partitioning/discuss/41982/Java-DP-%2B-DFS-solution
    // O(2^n) + O(n^2) = O(2^n)
    public static void main(String[] args) {
        PalindromePartitioning s = new PalindromePartitioning();
        List<List<String>> result = s.partition("aab");
        System.out.println(result);
    }
}