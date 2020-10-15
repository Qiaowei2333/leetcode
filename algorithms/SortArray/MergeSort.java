// leetcode 912
// time O(nlogn)  space O(n)
// 解释下 空间复杂度， 我一直以为是 O(nlogn), 因为假如 n=16
//  level 0 数组占空间： 16
//  level 1 所占空间： 8 + 8
//  level 2 占空间： 4 + 4 + 4 + 4
//  level 3：     2 + 2 + 2 + 2 + 2 + 2 + 2 + 2
//  level 4: 1 1 1 1 1 1 1 1 1 1 1 1  1 1 1 1 1  1 1 1 1  1 1 1
//  但是！ 程序递归不是同时parallel执行的， 是 16 -> 8 -> 4 -> 2 -> 1，再合并上去， 所以只占了 （1 + 1/2 + 1/4 + 1/ 8 ...）* n = 2n at most
// 所有空间是O（n）
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
      
      // merge two sorted array
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