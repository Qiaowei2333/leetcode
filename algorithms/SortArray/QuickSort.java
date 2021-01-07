// leetcode 912
// avg time O(nlogn), worst O(n2),  space O(1)
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

    // 这里取end 即最后一个数为pivot，因为取中点，中点可能已经被swap了，之后位置不确定 
    // 假如取中点 pivot = start + (end - start) / 2, [5,1,1,2,0,0] partition之后 pivotValue = 1, pivotIndex = 2, 循环swap之后，数组[0 0 1 2 5 1]
    // 原来在pivotIndex 2 的中点已经swap到最右去了，而程序并不知道
    // 用最右好处是，最有没有被swap过，等我找到pviotIndex再swap过去
    private int partition(int[] nums, int start, int end) {
        int pivotValue = nums[end];
        // remove line 22 with commented out area below to use mid value as pivot value
        // int mid = start + (end - start) / 2;
        // int pivotValue = nums[mid];
        // swap(nums, mid, end);
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
        int[] result = s.quickSortArray(new int[]{5,2,3,1});
        for (int elm : result) {
            System.out.println(elm);
        }
        // int privotIndex = s.partition(new int[]{7, 6, 1, 2, 3}, 0, 4);
        // System.out.println(privotIndex);
    }
}