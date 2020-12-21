// lc 162
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int start = 0; 
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid == nums.length - 1 || nums[mid] > nums[mid + 1]) {
                end = mid - 1;
            }
            else if (mid == 0 || nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            }
        }
        
        return start;
    }
    public static void main(String[] args) {
        
    }
}