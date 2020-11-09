// https://leetcode.com/discuss/interview-question/862600/
import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;
public class TransactionLogs {
    public static List<String> getFraudIds(String[] input, int threshold) {
        List<String> res = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String log : input) {
            String[] arr = log.split(" ");
            map.put(arr[0], map.getOrDefault(arr[0], 0) + 1);
            if (!arr[0].equals(arr[1])) {
                map.put(arr[1], map.getOrDefault(arr[1], 0) + 1); 
            }
        }
        Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> {
            return Integer.valueOf(b.getKey()) - Integer.valueOf(a.getKey());
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= threshold) {
                pq.offer(entry);
            }
        }
        while (!pq.isEmpty()) {
            res.add(pq.poll().getKey());
        }
        return res;
    }
    public static void main(String[] args) {
		String[] input = new String[] { "345366 89921 45", "029323 38239 23", "38239 345366 15", "029323 38239 77",
				"345366 38239 23", "029323 345366 13", "38239 38239 23" };
		System.out.println(getFraudIds(input, 3));
	}
}
