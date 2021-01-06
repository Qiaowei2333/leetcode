// lc 347
public class TopKFrequentElements {
    // sol1， bucket sort，桶排序排的是频率，依据频率大小排序，知道频率的区间[0, nums.length],适合桶排序
    // bucket sort time O(n)
    // List<Integer>[] list， 频率作为数组下标
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] list = new List[nums.length + 1]; // size取nums.length + 1, 因为频率最多也就是这么多，由于并不知道同样频率有几个，所以用List<Integer>作为element
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (list[val] == null) {
                list[val] = new ArrayList<>();
            }
            list[val].add(key);
        }
        int[] res = new int[k];
        int j = 0;
        for (int i = nums.length; i >= 0; i--) {
            if (list[i] == null) continue;
            for (int a : list[i]) {
                res[j++] = a;
                if (j == k) break;// break只能跳出当前循环
            }
            if (j == k) break;
        }
        return res;
    }

    // sol2， time O(nlog(n - k)), n-k是pq的size
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[k];
        int i = 0;
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
 
        int size = freq.size() - k;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            pq.offer(entry);
            System.out.println(entry.getKey());
            if (pq.size() > size) {
                
                res[i] = pq.poll().getKey();
                System.out.println("out from pq:" + res[i]);
                i++;
            }
        }
        return res;
    }

    
    public static void main(String[] args) {
        test123 solution = new test123();
        int[] res = solution.topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2);
        System.out.println(res);
    }
}
