import java.util.*;
public class test123 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(s, 0, list, res);
        return res;
    }
    
    private void dfs(String s, int start, List<String> list, List<List<String>> res) {
        if (start == s.length()) res.add(new ArrayList<>(list));
        for (int i = start; i < s.length(); i++) {
            String cur = s.substring(start, i + 1);
            if (!isPalindrome(cur)) continue;
            list.add(cur);
            dfs(s, i + 1, list, res);
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
        test123 solution = new test123();
        List<List<String>> res = solution.partition("aab");
        System.out.println(res);
    }
}
