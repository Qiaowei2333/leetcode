public class Fibonacci {
    // recursion time O(2^n)  space O(1)
    public static int nthNumberInFibonacci(int n) {
        if (n == 1 || n == 2) return n - 1;
        return nthNumberInFibonacci(n - 1) + nthNumberInFibonacci(n - 2);
    }

    // dp  time O(n)  space O(n)
    public static int nthNumberInFibonacciDP(int n) {
        if (n == 1) return 0;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    // dp  time O(n)  space O(1)
    static public int Fibonacci2(int n) {
        if (n == 0 || n == 1) return n;
        int pre2 = 0;
        int pre1 = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = pre2 + pre1;
            pre2 = pre1;
            pre1 = res;
        }
        return res;
    }

    public static void main(String[] args) {
        int res = nthNumberInFibonacciDP(2);
        System.out.println(res);
    }
}