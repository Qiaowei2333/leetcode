// lint6

public class MergeSortedArray {
    public int[] mergeSortedArray(int[] A, int[] B) {
        if(A == null || B == null) {
            return null;
        }

        int index = 0, i = 0, j = 0;
        int[] result = new int[A.length + B.length];

        while(i < A.length && j < B.length) {
            if(A[i] < B[j]) {
                result[index++] = A[i++];
            }
            else {
                result[index++] = B[j++];
            }
        }

        while(i < A.length) {
            result[index++] = A[i++];
        }
        while(j < B.length) {
            result[index++] = B[j++];
        }

        return result;
    }
    public static void main(String[] args) {
        System.out.println(1);

    }
}