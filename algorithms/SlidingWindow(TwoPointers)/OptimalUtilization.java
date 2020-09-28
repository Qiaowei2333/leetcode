import java.util.*;
/**
 * https://leetcode.com/discuss/interview-question/373202
 */
// similiar to lt 1099 twoSumLessThanK
public class OptimalUtilization {
    public List<int[]> optimal(List<int[]> a, List<int[]> b, int target) {
        if (a == null || a.isEmpty() || b == null || b.isEmpty()) {
            return new ArrayList<int[]>();
        }

        Collections.sort(a, (a1, a2) -> Integer.compare(a1[1], a2[1]));
        Collections.sort(b, (b1, b2) -> Integer.compare(b1[1], b2[1]));
        int m = a.size();
        int n = b.size();
        int i = 0;
        int j = n - 1;
        List<int[]> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        while (i < m && j >= 0) {
            int sum = a.get(i)[1] + b.get(j)[1];
            if (sum <= target) {
                // maybe duplicate ele
                if (sum > max) {
                    result.clear();
                    max = sum;
                    result.add(new int[]{a.get(i)[0], b.get(j)[0]});
                } else if (sum == max) {
                    result.add(new int[]{a.get(i)[0], b.get(j)[0]});
                }
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        OptimalUtilization sol = new OptimalUtilization();
        List<int[]> aa = new ArrayList<>();
        aa.add(new int[]{1, 8});
        aa.add(new int[]{2, 15});
        aa.add(new int[]{3, 9});
        aa.add(new int[]{4, 9});
        List<int[]> bb = new ArrayList<>();
        bb.add(new int[]{1, 8});
        bb.add(new int[]{2, 11});
        bb.add(new int[]{3, 12});
        List<int[]> res = sol.optimal(aa, bb, 20);
        for (int[] item : res) {
            System.out.println(Arrays.toString(item));
        }
    }
}