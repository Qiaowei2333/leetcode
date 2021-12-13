// There is a new product launched and its customer ratings are being recorded in an array. The ratings are being monitored and analyzed if there is any decrease in the ratings.
// Find the number of periods in which the rating is consecutively decreasing.

// Example - Ratings = [4,3,5,4,3]
// Periods (in other words sub arrays in which ratings are decreasing):
// One day periods = [4],[3],[5],[4],[3] (count of subarrays is 5)
// Two day periods = [4,3],[5,4],[4,3] (count of subarrays is 3)
// 3 day periods = [5,4,3] (count of subarrays is 1)
// So, the output for this example will be 9 (5 + 3 + 1)

// Ratings = [4, 4, 4, 4] - 单个数字的subarray也算decreasing subarray
// res = 1 + 1 + 1 + 1 = 4

// 解法  O(n), one pass.  left right pointer， 在符合要求的subarray直接公式计算total subarray: （n*(n+1 / 2)，n=right - left 接着继续扫

public class DecreasingSubarrays {
    public int countDecreasingSubarrays(int[] nums) {
        long res = 0;
        int l = 0;
        for (int r = 1; r < nums.length; r++) {
            if (nums[r - 1] <= nums[r]) {
                int count = r - l;
                res = res + (1 + count) * count / 2;
                l = r;
            }
        }
        int count = nums.length - l;
        res = res + (1 + count) * count / 2;
        return (int) res;
    }

    public static void main(String[] args) {
        DecreasingSubarrays s = new DecreasingSubarrays();
        int res = s.countDecreasingSubarrays(new int[]{4, 4, 4});
        System.out.println(res);
    }
}
