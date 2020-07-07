// lc 953
import java.util.*;
public class VerifyingAnAlienDictionary {
    // time O(m*n) m is words.length, n is the avg length of word
    public boolean isAlienSorted(String[] words, String order) {
        char[] cArr = order.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < cArr.length; i++) {
            map.put(cArr[i], i);
        }
        
        for (int i = 1; i < words.length; i++) {
            if (!isValidOrder(words[i - 1], words[i], map)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isValidOrder(String word1, String word2, Map<Character, Integer> map) {
        for (int i = 0; i < word1.length(); i++) {
            if (i >= word2.length()) {
                return false;
            }
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            int order1 = map.get(c1);
            int order2 = map.get(c2);
            if ( order1 > order2) {
                return false;
            } 
            else if (order1 < order2) {
                return true;
            }
        }
        // two identical strings
        return true;
    }
}