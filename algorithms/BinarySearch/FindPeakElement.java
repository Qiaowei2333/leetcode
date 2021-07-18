// lc 162
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        long[] newNums = new long[nums.length + 2];
        Arrays.fill(newNums, Long.MIN_VALUE);
        int i = 1;
        for (int num : nums) {
            newNums[i++] = num;
        }
        int start = 1, end = nums.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (newNums[mid + 1] > newNums[mid] && newNums[mid] > newNums[mid - 1]) {
                start = mid + 1;
            }
            else if (newNums[mid + 1] < newNums[mid] && newNums[mid] < newNums[mid - 1]) {
                end = mid - 1;
            }
            else if (newNums[mid] > newNums[mid + 1] && newNums[mid] > newNums[mid - 1]){
                return mid - 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }
}