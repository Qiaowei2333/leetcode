import java.util.Arrays;

// lint64

public class MergeSortedArray2 {
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        if(n == 0) {
            return;
        }

        int i = m - 1, j = n - 1, index = n + m - 1;

        while(i >= 0 && j >= 0) {
            if(A[i] > B[j]) {
                A[index--] = A[i--];
            }
            else {
                A[index--] = B[j--];
            }
        }

        while(j >= 0) {
            A[index--] = B[j--];
        }

        return;
    }

    public static void main(String[] args) {
        MergeSortedArray2 s = new MergeSortedArray2();
        int[] A = {2, 2, 2, 0, 0};
        int[] B = {2, 2};
        s.mergeSortedArray(A, 3, B, 2);
        System.out.println(Arrays.toString(A));
    }
}