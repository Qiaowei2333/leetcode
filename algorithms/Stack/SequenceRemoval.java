// tusimple oa
// sequence removal - remove a min increasing sequence, make the rest no duplicate
// 2 1 3 1 4 1 3 -> remove 1 1 3, remaining 2 3 4 1
import java.util.*;
public class SequenceRemoval {
    public static List<Integer> findSubsequence(List<Integer> arr) {
        List<Integer> res = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>(); // first map for all elements frequency
        Map<Integer, Integer> record = new HashMap<>(); // second map for duplicate elements
        Stack<Integer> stack = new Stack<>(); 

        int count = 0;
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
            if (map.get(a) == 1) {
                count++;
            }
            else {
                record.put(a, 0);
            }
        }

        int removeLen = arr.size() - count;
        int start = -1;
        while (true) {
            start = findNext(arr, start, map);
            if (start != -2) {
                int cur = arr.get(start);
                if (map.get(cur) - record.get(cur) == 1) continue;
                while (!stack.isEmpty() && stack.peek() > cur) {
                    int popVal = stack.pop();
                    record.put(popVal, record.get(popVal) - 1);
                }
                stack.push(cur);
                record.put(cur, record.get(cur) + 1);
            }
            else {
                break;
            }
        }

        if (stack.size() != removeLen || removeLen == 0)
            res.add(-1);
        else 
            while (!stack.isEmpty()) {
                int cur = stack.pop();
                res.add(0, cur);
            }

        return res;
    }

    // find next element appear more than once
    private static int findNext(List<Integer> arr, int start, Map<Integer, Integer> map) {
        for (int i = start + 1; i < arr.size(); i++) {
            int cur = arr.get(i);
            if (map.get(cur) > 1) {
                return i;
            }
        }
        return -2;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(Arrays.asList(0,1,0,3,2,3));
        List<Integer> res = findSubsequence(input);
        System.out.println(res);
    }
}
