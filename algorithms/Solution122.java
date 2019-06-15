package src.algorithms;

//public class Solution122 {
//    public int maxProfit(int[] prices) {
//        Arrays.sort(prices);
//        int l = 0;
//        int h = prices.length-1;
//        int profit = 0;
//        while(l<h){
//            profit+=(prices[h--]-prices[l++]);
//        }
//        return profit;
//    }
//}
public class Solution122 { 
public int maxProfit(int[] prices) {
    int total = 0;
    for (int i=0; i< prices.length-1; i++) {
        if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
    }
    
    return total;
 }
}
