import java.util.Queue;

public class FindMedianFromDataStream {
    /** initialize your data structure here. */
    Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b.compareTo(a));
	   
    Queue<Integer> minHeap = new PriorityQueue<>();
     // Adds a number into the data structure.
    public void addNum(int num) {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            maxHeap.offer(num);
            return;
        }
        
        if (num == 3) {
            System.out.println("start");
        }
        if (minHeap.isEmpty()) {
            int topMax = maxHeap.poll();
            if (num > topMax) {
                minHeap.offer(num);
                maxHeap.offer(topMax);
            } 
            else {
                maxHeap.offer(num);
                minHeap.offer(topMax);
            }
            return;
        }

        if (num >= maxHeap.peek() && num <= minHeap.peek()) {
            if (maxHeap.size() == minHeap.size()) {
                maxHeap.offer(num);
            }
            else {
                minHeap.offer(num);
            }
            return;
        }

        if (num <= maxHeap.peek()) {
            if (minHeap.size() == maxHeap.size()) {
                maxHeap.offer(num);
            }
            else {
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            }
            return;
        }

        if (num >= minHeap.peek()) {
            
            if (minHeap.size() == maxHeap.size()) {
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
                
            }
            else {
                minHeap.offer(num);
            }
            return;
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