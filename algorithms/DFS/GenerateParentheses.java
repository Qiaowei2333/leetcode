// lc 22
import java.util.*;
public class GenerateParentheses {
    // time O(2^2n) 总长度为2n，n个（，n个），每个都可以在或者不在，即便pruning了因为要valid，也是这个复杂度
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
        
        if (numL < n) {
            sb.append('(');
            dfs(sb, result, numL + 1, numR, n);
            sb.deleteCharAt(sb.length() - 1);
        }
 
        if (numL > numR) {
            sb.append(')');
            dfs(sb, result, numL, numR + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
 
    }
}