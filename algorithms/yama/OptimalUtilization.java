// yama oa
// https://leetcode.com/discuss/interview-question/373202
import java.util.*;

public class OptimalUtilization {
    List<int[]> findPairs(List<int[]> a, List<int[]> b, int target) {
        List<int[]> result = new ArrayList<>();
        Collections.sort(a, (i, j) -> i[1] - j[1]);
        Collections.sort(b, (i, j) -> i[1] - j[1]);
        int i = 0;
        int j = b.size() - 1;
        int max = Integer.MIN_VALUE;
        while (i <= a.size() - 1 && j >= 0) {
            int sum = a.get(i)[1] + b.get(j)[1];
            if (sum <= target) {
                if (sum >= max) {
                    if (sum > max) {
                        max = sum;
                        result.clear();
                    }
                    result.add(new int[]{a.get(i)[0], b.get(j)[0]});
                    int index = j - 1;
                    while (index >= 0 && b.get(j)[1] == b.get(index)[1]) {
                        result.add(new int[]{a.get(i)[0], b.get(index)[0]});
                        index--;
                    }
                }
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        OptimalUtilization s = new OptimalUtilization();
        List<int[]> a = new ArrayList<>();
        List<int[]> b = new ArrayList<>();
        a.add(new int[]{1, 3});
        a.add(new int[]{2, 3});
        a.add(new int[]{3, 5});
        a.add(new int[]{4, 7});
        a.add(new int[]{5, 10});

        b.add(new int[] {1, 2});
        b.add(new int[] {2, 3});
        b.add(new int[] {3, 4});
        b.add(new int[] {4, 5});
        b.add(new int[] {5, 7});
        b.add(new int[] {6, 7});
        List<int[]> result = s.findPairs(a, b, 10);
        Iterator<int[]> resultIterator = result.iterator();
        while (resultIterator.hasNext()) {
            System.out.println(Arrays.toString(resultIterator.next()));
        }
    }
}