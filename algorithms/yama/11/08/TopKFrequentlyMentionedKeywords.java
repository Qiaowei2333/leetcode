// https://leetcode.com/discuss/interview-question/542597/
import java.util.*;
public class TopKFrequentlyMentionedKeywords {
    // time O(numOfWordsInReviews + nlogk), n: num of keywords  space O(n)
    private static List<String> findKeywords(int k, String[] keywords, String[] reviews) {
        List<String> res = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for (String keyword : keywords) set.add(keyword);  
        Map<String, Integer> map = new HashMap<>();
        for (String review : reviews) {
            String[] words = review.split("\\W");
            Set<String> existed = new HashSet<>();
            for (String word : words) {
                word = word.toLowerCase();
                if (set.contains(word) && !existed.contains(word)) {
                    existed.add(word);
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
            }
        }
        Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> {
            if (a.getValue() != b.getValue()) {
                return a.getValue() - b.getValue();
            }
            else {
                return b.getKey().compareTo(a.getKey());
            }
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            res.add(0, pq.poll().getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        int k1 = 2;
        String[] keywords1 = { "anacell", "cetracular", "betacellular" };
        String[] reviews1 = { "Anacell provides the best services in the city", "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell", };
        int k2 = 2;
        String[] keywords2 = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
        String[] reviews2 = { "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services", "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell", "Betacellular is better than deltacellular.", };
        System.out.println(findKeywords(k1, keywords1, reviews1));
        System.out.println(findKeywords(k2, keywords2, reviews2));
    }
}
