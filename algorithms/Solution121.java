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
}
