// lc 819 垃圾题目
import java.util.*;
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for (String str : banned) set.add(str.toLowerCase());
        String[] words = paragraph.split("\\W");
        for (String word : words) {
            System.out.println(word);
        }
        Map<String, Integer> map = new HashMap<>(); 
        int max = 0;
        String res = "";
        for (String word : words) { 
            word = word.toLowerCase();
            if (set.contains(word) || word.length() == 0) continue;
            map.put(word, map.getOrDefault(word, 0) + 1);
            if (map.get(word) > max) {
                max = map.get(word);
                res = word;
            }
        }
        return res;
    }
}
