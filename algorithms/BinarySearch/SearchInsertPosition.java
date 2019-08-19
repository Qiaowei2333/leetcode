public class SearchInsertPosition {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: An integer
     */
    public int searchInsert(int[] A, int target) {
        if(A == null || A.length == 0) {
            return 0;
        }
        
        int start = 0, end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            System.out.println("mid = " + mid);
            if(A[mid] == target) {
                return mid;
            }
            else if(A[mid] > target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        System.out.println("start = " + start);
        System.out.println("end = " + end);
        if(target > A[end]) {
            return end + 1;
        } else if(target < A[start]) {
            return start;
        } else {
            return end;
        }
        
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4};
        SearchInsertPosition s = new SearchInsertPosition();
        int result = s.searchInsert(A, 4);
        System.out.println(result);
    }
}