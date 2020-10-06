// lc 128
// https://leetcode.com/problems/longest-consecutive-sequence/discuss/41055/My-really-simple-Java-O(n)-solution-Accepted
public class LongestConsecutiveSequence {
    // find left boundry num and right boundry num. Update their length in map.
    // no need to consider duplicate number, it won't increase the length of sequence
    // online sol: 数据一边读一边处理
    // time O(n)  space O(n)
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            // duplicates
            if (map.containsKey(num)) continue;  

            // check adjacent number to see if current num exist in a sequence
            int leftSum = map.containsKey(num - 1) ? map.get(num - 1) : 0; 
            int rightSum = map.containsKey(num + 1) ? map.get(num + 1) : 0;

            // sum is the length of sequence contains num
            int sum = leftSum + rightSum + 1;
            map.put(num, sum);

            // do nothing if num has no neighbors
            if (leftSum != 0 || rightSum != 0) { 
                map.put(num - leftSum, sum); // update left boundry length
                map.put(num + rightSum, sum); // update right boundry length
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    // offline sol : 读取所有数据再处理 https://www.youtube.com/watch?v=rc2QdQ7U78I&t=300s&ab_channel=HuaHua
    // time O(n)  space O(n)
    public int longestConsecutive2(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        // find lower boundry, lower boundry means num - 1 does not exist in set
        for (int num : nums) {
            if (!set.contains(num - 1)) {  // num - 1 not in set, so num is a lower boundry, start to count
                int count = 1;
                int temp = num + 1;
                while (set.contains(temp)) {
                    count++;
                    temp++;
                }
                res = Math.max(res, count);
            }
        }
        
        return res;
    }
}
