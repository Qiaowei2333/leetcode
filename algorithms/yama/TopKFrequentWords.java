//lc 692
import java.util.*;
public class TopKFrequentWords {
    public List<String> topKFrequent(final String[] words, final int k) {
        final List<String> result = new LinkedList<>();
        final Map<String, Integer> map = new HashMap<>();
        for (final String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        final PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> {
            if (a.getValue() == b.getValue()) {
                return b.getKey().compareTo(a.getKey());
            } else {
                return a.getValue() - b.getValue();
            }
        });
        
        for (final Map.Entry<String, Integer> entry: map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        while (!queue.isEmpty()) {
            result.add(0, queue.poll().getKey());
        }

        return result;
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