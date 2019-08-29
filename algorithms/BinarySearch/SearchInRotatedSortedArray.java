public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        if(A == null || A.length == 0) {
            return -1;
        }

        int start = 0, end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid] == target) {
                return mid;
            }
            if(A[mid] >= A[start]) {
                if(target >= A[start] && target <= A[mid]) {
                    end = mid;
                }
                else {
                    start = mid;
                }   
            }
            else {
                if(target <= A[end] && target >= A[mid]) {
                    start = mid;
                }
                else {
                    end = mid;
                }
            }
        }

        if(A[start] == target) {
            return start;
        }
        if(A[end] == target) {
            return end;
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        int[] A = {1001,10001,10007,1,10,101,201};
        int result = s.search(A, 10001);
        System.out.println(result);
    }
}