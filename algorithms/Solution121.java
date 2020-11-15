package src.algorithms;

class Solution121 {
    public int maxProfit(int[] prices) {
    	if(prices.length<1) return 0;
        int min = prices[0];
        int result=0;
        for(int price:prices) {
            if(min<price){
                result = Math.max(result,price-min);
            }
            else {
                min = price;
            }
        }
        return result;
    }

    // DP sol, time O(n)  space O(n), dp[i] stands for, when selling at day i+1, most profit made
    public int maxProfitDP(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int[] dp = new int[n]; 
        dp[0] = 0;
        int max = 0;
        for (int i = 1; i < n; i++) {
             dp[i] = dp[i - 1] + (prices[i] - prices[i - 1]);
            if (dp[i] < 0) dp[i] = 0;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
