// lc 969
// https://www.geeksforgeeks.org/pancake-sorting/
import java.util.*;
public class PancakeSorting {
    // time O(n^2) space O(n)   
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for (int i = arr.length; i > 1; i--) {
            int maxIndex = findMax(arr, 0, i - 1); // for (i = 0; A[i] != x; ++i);  find max because max = curLength, 根据题目，nums.length个数，都不同，且在 1 <= nums[i] <= nums.length，每次找的max就是length
            flip(arr, maxIndex + 1);
            res.add(maxIndex + 1);
            flip(arr, i);
            res.add(i);
        }
        return res;
    }
    
    private void flip(int[] arr, int k) {
        int i = 0;
        while (i < k / 2) {
            int temp = arr[i];
            arr[i] = arr[k - 1 - i];
            arr[k - 1 - i] = temp;
            i++;
        }
    }
    
    private int findMax(int[] arr, int start, int end) {
        int max = arr[start];
        int index = start;
        for (int i = start; i <= end; i++) {
            if (arr[i] > max) {
                index = i;
                max = arr[i];
            }
        }
        return index;
    }
}
