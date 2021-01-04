// lc 17
import java.util.*;
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.equals("")) return res;
        Map<Character, List<String>> map = new HashMap<>();
        map.putIfAbsent('2', new ArrayList<>(Arrays.asList(new String[]{"a", "b", "c"})));
        map.putIfAbsent('3', new ArrayList<>(Arrays.asList(new String[]{"d", "e", "f"})));
        map.putIfAbsent('4', new ArrayList<>(Arrays.asList(new String[]{"g", "h", "i"})));
        map.putIfAbsent('5', new ArrayList<>(Arrays.asList(new String[]{"j", "k", "l"})));
        map.putIfAbsent('6', new ArrayList<>(Arrays.asList(new String[]{"m", "n", "o"})));
        map.putIfAbsent('7', new ArrayList<>(Arrays.asList(new String[]{"p", "q", "r", "s"})));
        map.putIfAbsent('8', new ArrayList<>(Arrays.asList(new String[]{"t", "u", "v"})));
        map.putIfAbsent('9', new ArrayList<>(Arrays.asList(new String[]{"w", "x", "y", "z"})));
        StringBuilder sb = new StringBuilder();
        dfs(0, digits, map, sb, res);
        return res;
    }
    
    private void dfs(int depth, String digits, Map<Character, List<String>> map, StringBuilder sb, List<String> res) {
        if (depth == digits.length()) {
            res.add(sb.toString());
            return;
        } 

        char cur = digits.charAt(depth);
        for (String l : map.get(cur)) {
            sb.append(l); 
            dfs(depth + 1, digits, map, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
