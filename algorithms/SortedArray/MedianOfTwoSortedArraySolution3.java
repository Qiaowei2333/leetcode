public class MedianOfTwoSortedArraySolution3 {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { 
            return findMedianSortedArrays(B,A); 
        }
        int start = 0;
        int end = m - 1;
        
    }
    
    public static void main(String[] args) {

    }
}