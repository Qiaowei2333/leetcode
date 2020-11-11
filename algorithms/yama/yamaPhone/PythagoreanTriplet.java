package yamaPhone;

// 给一个数组找出符合勾股定理的所有组合 （查了下geekforGeeks上有原题）
// 3sum
import java.util.*;
public class PythagoreanTriplet {
    // time O(n^2), space O(n)
    public static List<List<Integer>> findAllTriplet(int[] arr) {
        // code here
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            int sum = arr[i] * arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (map.containsKey(sum - arr[j] * arr[j]) && !map.containsKey(arr[j] * arr[j])) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(arr[i]);
                    triplet.add(arr[j]);
                    triplet.add((int) Math.sqrt(1.0 * sum - 1.0 * arr[j] * arr[j]));
                    res.add(triplet);
                }
                map.put(arr[j] * arr[j], 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = findAllTriplet(new int[]{1, 2, 2, 3, 3, 4, 4, 5, 5, 5});
        System.out.println(res);
    }
}
