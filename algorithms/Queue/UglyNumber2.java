// lc 264 https://www.jiuzhang.com/solutions/ugly-number-ii/
import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;
public class UglyNumber2 {
    // dp sol  time O(n)  space O(n)
    public int nthUglyNumber(int n) {
        int i2 = 0, i3 = 0, i5 = 0;
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        while (nums.size() < n) {
            int next2 = nums.get(i2) * 2;
            int next3 = nums.get(i3) * 3;
            int next5 = nums.get(i5) * 5;
            int next = Math.min(next2, Math.min(next3, next5));
            nums.add(next);
            if (next == next2) i2++;
            if (next == next3) i3++;
            if (next == next5) i5++;
        }
        return nums.get(n - 1);
    }

    // priority queue  time O(nlogn)   space O(n)
    // use long in case overflow
    public int nthUglyNumber2(int n) {
        Queue<Long> pq = new PriorityQueue<>((a, b) -> Long.compare(a, b));
        Set<Long> set = new HashSet<>(); // in case put duplicate number in queue
        pq.offer(Long.valueOf(1));
        set.add(Long.valueOf(1));
        int[] factors = new int[]{2, 3, 5};
        long curUgly = 1;
        for (int i = 0; i < n; i++) {
            curUgly = pq.poll();
            for (int factor : factors) {
                long newUgly = curUgly * factor;
                if (!set.contains(newUgly)) {
                    pq.offer(newUgly);
                    set.add(newUgly);
                }
            }
        }
        return (int) curUgly;
    }

    public static void main(String[] args) {
        UglyNumber2 s = new UglyNumber2();
        int res = s.nthUglyNumber(10);
        System.out.println(res);
    }
}
