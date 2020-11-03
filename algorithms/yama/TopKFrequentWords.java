//lc 692
import java.util.*;
public class TopKFrequentWords {
    // time O(nlogk), space O(n)
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.freq == b.freq) {
                return b.str.compareTo(a.str);
            }
            else {
                return a.freq - b.freq;
            }
        });
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            res.add(0, cur.str);
        }
        
        return res;
    }
    
    static class Pair {
        String str;
        int freq;
        public Pair(String str, int freq) {
            this.str = str;
            this.freq = freq;
        }
    }

    public static void main(final String[] args) {
        // TopKFrequentWords s = new TopKFrequentWords();
        // String[] words = {"i", "love", "leetcode", "i", "love", "coding", "leetcode"};
        // int k = 2;
        // List<String> result = s.topKFrequent(words, k);
        // System.out.println(result);

        		// if we use Stack, output will be [1, 2, 3]
		Stack<Integer> stack = new Stack<>();

		// if we use Deque, output will be [3, 2, 1]
		// Deque<Integer> stack = new ArrayDeque<>();

		stack.push(1);
		stack.push(2);
        stack.push(3);

        // System.out.println(stack.removeFirst());
        // System.out.println(stack.removeFirst());
        // System.out.println(stack.removeFirst());
        
        for (Integer item: stack) {
			System.out.println(item);
		}
    }
}