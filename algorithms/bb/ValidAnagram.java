// lc 242
import java.util.*;
public class ValidAnagram {
    // solve by sorting
    public boolean isAnagramSort(String s, String t) {
        if (s == null) {
            return false;
        }
        
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        s = new String(arr1);
        t = new String(arr2);
        
        return s.equals(t);
    }

    // solve by HashMap
    public boolean isAnagram(String s, String t) {
        if (s == null) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        for (char ch : t.toCharArray()) {
            if (map.containsKey(ch)) {
                int val = map.get(ch);
                if (val == 0) {
                    return false;
                } else if (val == 1) {
                    map.remove(ch);
                } else {
                    val--;
                    map.put(ch, val);
                }
            } else {
                System.out.println(ch);
                return false;
            }
        }
        if (map.size() == 0) {
            return true;
        } else {
            return false; 
        }
        
    }
}