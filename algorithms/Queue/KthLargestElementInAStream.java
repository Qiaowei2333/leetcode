// lc 703
import java.util.*;
public class KthLargestElementInAStream {
    private Queue<Integer> minQ;
    private int k;
        
    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        minQ = new PriorityQueue<>();
        for (int num : nums) {
            minQ.offer(num);
            if (minQ.size() > k) {
                minQ.poll();
            }
        }
        
    }
    
    public int add(int val) {
        minQ.offer(val);
        if (minQ.size() > k) {
            minQ.poll();
        }
        return minQ.peek();
    }
}
