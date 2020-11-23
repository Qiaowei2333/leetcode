// lc 713 https://leetcode.com/problems/subarray-product-less-than-k/discuss/108861/JavaC%2B%2B-Clean-Code-with-Explanation
// 每新加入一个符合条件的数，都是加入j - left + 1 个新subarray
public class SubarrayProductLessThanK {
    // two pointers O(n)
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        int count = 0;
        int product = 1;
        int left = 0;
        for (int j = 0; j < nums.length; j++) {
            product *= nums[j];
            if (product < k) {// 符合条件，计算由于新加入nums[j],产生的新subarray个数
                count += (j - left + 1);
            }
            else {
                while (product >= k && left <= j) {
                    product /= nums[left];
                    left++;
                }
                // 此时product已经符合条件，需要计算新加入的nums[j]
                count += (j - left + 1);
            }
        }
        return count;
    }
}
