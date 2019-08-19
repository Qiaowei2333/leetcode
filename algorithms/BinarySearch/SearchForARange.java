import java.util.*;

public class SearchForARange {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] result = new int[] {-1, -1};
        if(A == null || A.length == 0) {
            return result;
        }
        
        int start = 0, end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(A[mid] == target) {
                  end = mid;
            }
            else if(A[mid] > target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        
        if(A[start] == target) {
            result[0] = start;
        } 
        else if(A[end] == target) {
            result[0] = end;
        }
        else {
            return result;
        }
        
        start = result[0]; 
        end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(A[mid] == target) {
                start = mid;
            }
            else if(A[mid] > target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        
        if(A[end] == target) {
            result[1] = end;
        } 
        else if(A[start] == target) {
            result[1] = start;
        }
        
        return result;
        
    }

    public static void main(String args[]) {
        int[] nums = new int[]{1, 2, 3, 4, 4, 5};
        SearchForARange s = new SearchForARange();
        int[] result = s.searchRange(nums, 4);
        System.out.println(Arrays.toString(result));
    }
}