// lc 1086  这道题没有说 id是连续的，所以treemap好过hashmap，可以自动sort the key in natural order
import java.util.*;

public class HighFive {
    // time O(nlogn) space O(k)   k: number of students
    // this sol applies to student id not consecutive
    public int[][] highFive(int[][] items) {
        Arrays.sort(items, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            else {
                return b[1] - a[1];
            }
        });
        
        int count = 1;
        for (int i = 0; i < items.length - 1; i++) {
            if (items[i][0] != items[i + 1][0]) count++;
        }
        
        int[][] res = new int[count][2];
        int m = 0;
        int curIdx = items[0][0];
        int countId = 1;
        int sum = items[0][1];
        for (int i = 0; i < items.length; i++) {
            if (countId < 5) {
                countId++;
                sum += items[i][1];
            }
            else {
                int avg = sum / countId;
                res[m][0] = curIdx;
                res[m][1] = avg;
                m++;
                while (i < items.length && items[i][0] == curIdx) i++;
                if (i < items.length) {
                    curIdx = items[i][0];
                    sum = items[i][1];
                    countId = 1;
                }
            }
        }
        if (m < count) {
            int avg = sum / countId;
            res[m][0] = curIdx;
            res[m][1] = avg;
        }
        return res;
    }

    // time O(nlogn)  PriorityQueue offer, poll  takes O(logn),  TreeMap get, put, containsKey take O(nlogn)
    public int[][] highFive2(int[][] items) {
    
        Map<Integer, Queue<Integer>> map = new TreeMap<>();
         
        for(int[] item : items){
            int id = item[0];
            int score = item[1];
            
            if(!map.containsKey(id)){
                map.put(id, new PriorityQueue<Integer>());
                map.get(id).offer(score);
            } 
            else {
                Queue<Integer> pq = map.get(id);
                pq.offer(score);
                if(pq.size() > 5){
                    pq.poll();
                }
            }
        }
         
        int index = 0;
         
        int[][] res = new int[map.size()][2];
         
        for(Map.Entry<Integer, Queue<Integer>> entry : map.entrySet()){
            int id = entry.getKey();
            res[index][0] = id;
         
            Queue<Integer> pq = map.get(id);
            int sum = 0;
            
            while(!pq.isEmpty()){
                sum += pq.poll();
            }
          
            res[index][1] = sum / 5;
            
            index++;
        }
         
         return res;  
    }

	
	public static void main(String[] args) {
		HighFive s = new HighFive();
		int[][] items = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
		int[][] result = s.highFive2(items);
		System.out.println(Arrays.toString(result));
	}
}