// lc 905
public class SortArrayByParity {
    // two pointers   time O(n), space O(1)
    public int[] sortArrayByParity(int[] A) {
        int oddIndex = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                swap(A, i, oddIndex);
                oddIndex++;
            }
        }
        return A;
    }
    
    private void swap(int[] A, int index1, int index2) {
        if (index1 == index2) return;
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }
}
