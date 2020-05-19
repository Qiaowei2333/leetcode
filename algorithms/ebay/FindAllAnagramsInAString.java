// lc 438
import java.util.*;
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() < p.length()) {
            return result;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> temp = new HashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (i >=  p.length()) {
                int valPop = temp.get(arr[i - p.length()]);
                if (valPop == 1) {
                    temp.remove(arr[i - p.length()]);
                }
                else {
                    temp.put(arr[i - p.length()], valPop - 1);
                }
            }
            temp.put(arr[i], temp.getOrDefault(arr[i], 0) + 1);
            if(compare(map, temp)) result.add(i - p.length() + 1);
        }
        return result;
    }
    
    private boolean compare(Map<Character, Integer> map, Map<Character, Integer> temp) {
        if (map.size() != temp.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : temp.entrySet()) {
            int val = entry.getValue();
            char key = entry.getKey();
            if (!map.containsKey(key) || map.get(key) != val) {
                return false;
            } 
        }
        return true;
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString s = new FindAllAnagramsInAString();
        List<Integer> result = s.findAnagrams("cbaebabacd", "abc");
        System.out.println(result);
    }

}