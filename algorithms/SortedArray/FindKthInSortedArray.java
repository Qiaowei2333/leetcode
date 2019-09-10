public class FindKthInSortedArray {
    public double findKth(int[] A, int startOfA, int[] B, int startOfB, int k) {
        if(startOfA >= A.length) {
            return B[startOfB + k - 1];
        }

        if(startOfB >= B.length) {
            return A[startOfA + k - 1];
        }

        if(k == 1) {
            return Math.min(A[startOfA], B[startOfB]);
        }

        int halfKthOfA = startOfA + k - 1 < A.length ? A[startOfA + k - 1] : Integer.MAX_VALUE;
        int halfKthOfB = startOfB + k - 1 < B.length ? B[startOfB + k - 1] : Integer.MAX_VALUE;

        if(halfKthOfA < halfKthOfB) {
            return findKth(A, startOfA + k / 2, B, startOfB, k - k / 2);
        }
        else {
            return findKth(A, startOfA, B, startOfB + k / 2, k - k / 2);
        }
    } 
    public static void main(String[] args) {
        FindKthInSortedArray s = new FindKthInSortedArray();
        int[] A = {1,2,3,4,5,6};
        int[] B = {2,3,4,5};
        double result = s.findKth(A, 0, B, 0, 1);
        System.out.println(result);
    }
}