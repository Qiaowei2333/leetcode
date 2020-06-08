// lc 22
import java.util.*;
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        dfs(sb, result, 0, 0, n);
        return result;
    }
    
    private void dfs(StringBuilder sb, List<String> result, int numL, int numR, int n) {
        if (numL == n && numR == n) {
            result.add(sb.toString());
            return;
        }
        if (numL < numR || numL > n) {
            return;
        }
        sb.append('(');
        dfs(sb, result, numL + 1, numR, n);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(')');
        dfs(sb, result, numL, numR + 1, n);
        sb.deleteCharAt(sb.length() - 1);
    }
}