// leetcode 912
public class MergeSort {
    public int[] mergeSort(int[] nums, int start, int end) {
        if (start == end) {
          return new int[]{nums[start]};
        }
        
        int mid = start + (end - start) / 2;
        int[] leftSorted = mergeSort(nums, start, mid);
        int[] rightSorted = mergeSort(nums, mid + 1, end);
        
        int[] sortedArray = merge(leftSorted, rightSorted);
        
        return sortedArray;
      }
      
      private int[] merge(int[] left, int[] right) {
        int[] mergedArray = new int[left.length + right.length];
        int i = 0, j = 0, m = 0;
    
        while (i < left.length && j < right.length) {
          if (left[i] < right[j]) {
            mergedArray[m++] = left[i++];
          }
          else {
            mergedArray[m++] = right[j++];
          }
        }
        
        while(i < left.length) {
          mergedArray[m++] = left[i++];
        }
        
        while(j < right.length) {
          mergedArray[m++] = right[j++];
        }
        
        return mergedArray;
      }
      
      public static void main(String[] args) {
        MergeSort s = new MergeSort();
        int[] nums = new int[]{4, 5, 6, 7, 1, 2, 3};
        nums = s.mergeSort(nums, 0, nums.length - 1);
        
        for (int e: nums) {
          System.out.println(e);
        }
      }
}