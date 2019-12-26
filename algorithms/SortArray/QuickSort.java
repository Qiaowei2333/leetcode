// leetcode 912
public class QuickSort {
    public int[] quickSortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start <= end) {
            int pivot = partition(nums, start, end);
            quickSort(nums, start, pivot - 1);
            quickSort(nums, pivot + 1, end);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int pivotValue = nums[end];
        int pivotIndex = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < pivotValue) {
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


    public static void main(String[] args) {
        QuickSort s = new QuickSort();
        int[] result = s.quickSortArray(new int[]{1, 2});
        for (int elm : result) {
            System.out.println(elm);
        }
        // int privotIndex = s.partition(new int[]{7, 6, 1, 2, 3}, 0, 4);
        // System.out.println(privotIndex);
    }
}