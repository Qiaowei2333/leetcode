public class BestTimeToBuyAndSellStock2 {
    // O(n^2) dp sol
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] dp = new int[len + 1]; // dp[i] - if sell at len i, the max profit you can make 
        int max = 0;
        for (int i = 2; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + prices[i - 1] - prices[j]);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    
    // 画图分情况讨论
    // 第一种， i到j点永远是递增的
    // 第二种， i到j中间有下降的
    public int maxProfit2(int[] prices) {
        int total = 0;
        for (int i=0; i< prices.length-1; i++) {
            if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
        }
        
        return total;
    }
}
