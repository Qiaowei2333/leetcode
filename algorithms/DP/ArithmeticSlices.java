// lc 413 不算高频
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) return 0;
        int diff = A[1] - A[0];
        int res = 0;
        int count = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] - A[i - 1] == diff) { // dp思想
                count++;
                if (count >= 3) {
                    res += count - 2;
                }
            }
            else {
                diff = A[i] - A[i - 1];
                count = 2;
            }
        }
        return res;
    }
}
