// lc131
import java.util.*;
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        List<String> list = new ArrayList<>();
        helper(s, list, 0, result);
        return result;
    }
    
    private void helper(String s, List<String> list, int startPos, List<List<String>> result) {
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

    public static void main(String[] args) {
        PalindromePartitioning s = new PalindromePartitioning();
        List<List<String>> result = s.partition("aab");
        System.out.println(result);
    }
}