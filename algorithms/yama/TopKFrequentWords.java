//lc 692
import java.util.*;
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> {
            if (a.getValue() == b.getValue()) {
                return a.getKey().compareTo(b.getKey());
            } else {
                return b.getValue() - a.getValue();
            }
        });
        
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            queue.offer(entry);
            // if (queue.size() > k) {
            //     queue.poll();
            // }
        }
        int i = 0;
        while (!queue.isEmpty() && i < k) {
            result.add(queue.poll().getKey());
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        TopKFrequentWords s = new TopKFrequentWords();
        String[] words = {"i", "love", "leetcode", "i", "love", "coding", "leetcode"};
        int k = 2;
        List<String> result = s.topKFrequent(words, k);
        System.out.println(result);
    }
}