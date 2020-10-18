// lc 295
import java.util.Queue;

public class FindMedianFromDataStream {
    /** initialize your data structure here. */
    Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.valueOf(b) - Integer.valueOf(a)); // ((a, b) -> b.compareTo(a));
	   
    Queue<Integer> minHeap = new PriorityQueue<>();
     // Adds a number into the data structure.
    public void addNum(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.offer(num);
            return;
        }

        if (maxHeap.size() == minHeap.size()) {
            if (num <= minHeap.peek()) {
                maxHeap.offer(num);
            }
            else {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            }
        }
        else {
            if (maxHeap.size() > minHeap.size()) {
                if (num >= maxHeap.peek()) {
                    minHeap.offer(num);
                }
                else {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(num);
                }
            }
        }
    }
 
     // Returns the median of current data stream
    public double findMedian() {
        return maxHeap.size() > minHeap.size()
            ? maxHeap.peek()
            : ((double) maxHeap.peek() + (double) minHeap.peek()) / 2;
    }

    // // 精简的方法
    // public void addNum1(int num) {
    //     maxHeap.add(num);
    //     minHeap.add(maxHeap.poll());
    //     if (maxHeap.size() < minHeap.size())
    //         maxHeap.add(minHeap.poll());
    // }
}