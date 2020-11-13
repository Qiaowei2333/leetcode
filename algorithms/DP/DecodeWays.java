// lc 91
public class DecodeWays {
    // time O(n) space O(n)
    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        int[] dp = new int[arr.length];
        if (arr.length == 1) {
            return isValidOneDigit(arr, 0) ? 1 : 0;
        }
        dp[0] = isValidOneDigit(arr, 0) ? 1 : 0;
        dp[1] = dp[0] * (isValidOneDigit(arr, 1) ? 1 : 0) + 1 * (isValidTwoDigit(arr, 0, 1) ? 1 : 0);
        for (int i = 2; i < arr.length; i++) {
            int prev1 = (isValidOneDigit(arr, i) ? 1 : 0) * dp[i - 1];
            int prev2 = (isValidTwoDigit(arr, i - 1, i) ? 1 : 0) * dp[i - 2];
            dp[i] = prev1 + prev2;
        }
        return dp[dp.length - 1];
    }
    
    private boolean isValidOneDigit(char[] arr, int i) {
        char c = arr[i];
        if (c == '0') {
            return false;
        }
        else {
            return true;
        }
    }
    
    private boolean isValidTwoDigit(char[] arr, int i, int j) {
        char first = arr[i];
        char second = arr[j];
        if(first == '0') {
            return false;
        }
        else if (first == '1') {
            return true;
        }
        else if (first == '2' && second <= '6'){
            return true;
        }
        else {
            return false;
        }
    }
}
