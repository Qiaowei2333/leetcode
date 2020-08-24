// lc4 merge two sorted array then find median, time O(m + n), space O(m + n)
public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int[] newArray = new int[A.length + B.length];
        int i = 0, j = 0, m = 0;
        while(i < A.length && j < B.length) {
            if(A[i] > B[j]) {
                newArray[m++] = B[j++];
            }
            else {
                newArray[m++] = A[i++];
            }
        }

        while(i < A.length) {
            newArray[m++] = A[i++];
        }
        while(j < B.length) {
            newArray[m++] = B[j++];
        }   
        
        if(m % 2 == 0) {
            return ((double)(newArray[m / 2]) + (double)newArray[m / 2 - 1]) / 2;
        }
        else {
            return (double)newArray[m / 2];
        }

    }
    
    public static void main(String[] args) {
        MedianOfTwoSortedArray s = new MedianOfTwoSortedArray();
        int[] A = {1, 2, 3, 4, 5, 6};
        int[] B = {2, 3, 4, 5};
        double result = s.findMedianSortedArrays(A, B);
        System.out.println(result);
    }
}