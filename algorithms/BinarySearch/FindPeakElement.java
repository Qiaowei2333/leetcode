public class FindPeakElement {
    public int findPeak(int[] A) {
        int start = 0, end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(peak(A, mid) == 0) {
                return mid;
            }
            else if(peak(A, mid) == 1){
                start = mid;
            }
            else {
                end = mid;
            }
        }

        if(A[start] < A[start + 1]) {
            return start;
        }
        // if(A[end] < A[end - 1]) {
            return end;
        // }
    }

    public int peak(int[] A, int i) {
        if(A[i] > A[i - 1] && A[i] > A[i + 1]) {
            return 0;
        }
        else if(A[i] < A[i - 1] && A[i] > A[i + 1]) {
            return -1;
        }
        else {
            return 1;
        }
    }
    public static void main(String[] args) {
        
    }
}