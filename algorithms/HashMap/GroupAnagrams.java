// lc 49 https://leetcode.com/problems/group-anagrams/discuss/19176/Share-my-short-JAVA-solution
import java.util.*;
public class GroupAnagrams {
    // encode the key using sort O(nlogn)
    // time O(m*nlogn)  m - length of strs, n - max length of str
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String newStr = new String(ca);
            if (!map.containsKey(newStr)) {
                List<String> newList = new ArrayList<>();
                map.put(newStr, newList);
                res.add(newList);
            }
            map.get(newStr).add(s);
        }
        return res;
    }
    // encode the key using array
    // time O(m*n)  m - length of strs, n - max length of str
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String newStr = new String(ca);
            if (!map.containsKey(newStr)) {
                List<String> newList = new ArrayList<>();
                map.put(newStr, newList);
                res.add(newList);
            }
            map.get(newStr).add(s);
        }
        return res;
    }

}
