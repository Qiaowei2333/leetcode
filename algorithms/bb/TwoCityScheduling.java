// lc1029
import java.util.*;
public class TwoCityScheduling {
    private class CostDiff {
        int id;
        int diff;
        public CostDiff(int id, int A, int B) {
            this.diff = B - A;
            this.id = id;
        }
    }
    // greedy
    // 假设全选A，sum = A1 + A2 + A3 + A4 
    // 让你挑一个A换成B， 尽量减少sum， 换之后 sum = A1 + A2 + A3 + A4 + (Bi - Ai)  i = 1, 2, 3, 4
    // 为了让sum小， Bi - Ai 就要越小越好， 所以要sort based on （B - A), 并且从最小的开始换成B
    public int twoCitySchedCost(int[][] costs) {
        List<CostDiff> list = new ArrayList<>();
        for (int i = 0; i < costs.length; i++) {
            list.add(new CostDiff(i, costs[i][0], costs[i][1]));
        }

        Collections.sort(list, (a, b) -> a.diff - b.diff);

        int sum = 0;
        for (int j = 0; j < list.size(); j++) {
            CostDiff cur = list.get(j);
            int index = cur.id;
            if (j < list.size() / 2) {
                sum += costs[index][1];
            }
            else {
                sum += costs[index][0];
            }
        } 
        
        return sum;
    }
}