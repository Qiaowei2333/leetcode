// lc 215 quick select  wost case o(n^2) avg time O(n), 原因每次取一半（近似， 当你n很大，平均下来可以看作每次取一半） 
// T(n) = cn + T(n/2)
// T(n/2) = cn/2 + T(n/4)
// T(n/4) = cn/2 + T(n/8)
// .
// .
// .
// T(2) = c.2 + T(1)
// T(1) = c.1 + ...
// c(n + n/2 + n/4 + ... + 2 + 1) = c(2n) 
// https://stackoverflow.com/questions/5945193/average-runtime-of-quickselect
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {// start == end 是为了 [1]，k = 1的情况， 如果没有等号，会返回-1
            int pivotIndex = partition(nums, start, end);
            if (pivotIndex == k - 1) {
                return nums[pivotIndex];
            }
            else if (pivotIndex > k - 1) {
                end = pivotIndex - 1;
            }
            else {
                start = pivotIndex + 1;
            }
        }
        return -1;
    }
    
    private int partition(int[] nums, int start, int end) {
        int pivotValue = nums[end];
        int pivotIndex = start;
        for (int i = start; i < end; i++) {
            if (nums[i] > pivotValue) {
                swap(nums, i, pivotIndex);
                pivotIndex++;
            }
        }
        swap(nums, pivotIndex, end);
        return pivotIndex;
    }
    
    private void swap(int[] nums, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
