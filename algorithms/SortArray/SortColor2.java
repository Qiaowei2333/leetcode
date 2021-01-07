// lint 143 quick sort sol1, counting sort sol2
// https://aaronice.gitbook.io/lintcode/high_frequency/sort_colors_ii
public class SortColor2 {
    // 可以quicksort，可以counting sort， 可以用two pointers
    public void sortColors2(int[] colors, int k) {
        quickSort(colors, 0, colors.length - 1);
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

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortColor2 s = new SortColor2();
        int[] input = new int[]{3,2,2,1,4};
        s.sortColors2(input, 4);
        for (int elm : input) {
            System.out.println(elm);
        }
        // int privotIndex = s.partition(new int[]{7, 6, 1, 2, 3}, 0, 4);
        // System.out.println(privotIndex);
    }
}
