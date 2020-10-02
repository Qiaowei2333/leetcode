// lc 969
// https://www.geeksforgeeks.org/pancake-sorting/
import java.util.*;
public class PancakeSorting {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for (int i = arr.length; i > 1; i--) {
            int maxIndex = findMax(arr, 0, i - 1);
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
