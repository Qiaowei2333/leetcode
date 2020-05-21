public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        int l = 0, r = A.length - 1, idx = A.length - 1;
        while (l <= r) {
            if (Math.abs(A[l]) > Math.abs(A[r])) {
                result[idx] = A[l] * A[l];
                idx--;
                l++;
            }
            else {
                result[idx] = A[r] * A[r];
                idx--;
                r--;
            }
        }
        return result;
    }
}