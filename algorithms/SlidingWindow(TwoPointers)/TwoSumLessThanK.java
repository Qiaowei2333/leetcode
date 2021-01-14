// lc 1099
import java.util.*;

public class TwoSumLessThanK {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int i = 0;
        int j = A.length - 1;
        int max = -1;
        while (i < j) {
            int sum = A[i] + A[j];
            if (sum < K) {
                System.out.println(sum);
                max = Math.max(max, sum);
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        TwoSumLessThanK s = new TwoSumLessThanK();
        int[] A = new int[]{34, 23, 1, 24, 75, 33, 54, 8};
        int result = s.twoSumLessThanK(A, 60);
        System.out.println(result);
    }
}