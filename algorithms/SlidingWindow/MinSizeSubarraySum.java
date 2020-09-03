// LC 209
public class MinSizeSubarraySum {
    // TIME O(N) SPACE O(1)
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int minLen = Integer.MAX_VALUE;
        int l = 0, r = 0;
        int sum = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum >= s) {
                minLen = Math.min(minLen, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

        // TIME O(nlogn) SPACE O(n)
        public int minSubArrayLen1(int s, int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int[] pfxSum = new int[nums.length + 1];
            pfxSum[0] = 0;
            for (int i = 0; i < nums.length; i++) {
                pfxSum[i + 1] = pfxSum[i] + nums[i];
            }
            int minLen = Integer.MAX_VALUE;
            for (int i = 0; i < pfxSum.length; i++) {
                int firstPos = findFirstBigOrEqual(pfxSum, i, pfxSum.length - 1, pfxSum[i] + s);
                if (firstPos == pfxSum.length) break;
                minLen = Math.min(minLen, firstPos - i);
            }
            return minLen == Integer.MAX_VALUE ? 0 : minLen;
        }
        
        private int findFirstBigOrEqual(int[] nums, int start, int end, int target) {
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] >= target) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            return start;
        }
}