// lc 322
import java.util.*;
public class CoinChange {
    // dfs + greedy + pruning
    // https://www.youtube.com/watch?v=uUETHdijzkA&t=305s&ab_channel=HuaHua
    
    // dp sol time O(amount * coins.length)
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); 
        dp[0] = 0; // dp[i] - least number of coins to make up amount i
        for(int i = 0; i <= amount; i++){
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) 
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        } 
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange s = new CoinChange();
        int res = s.coinChange(new int[]{1,2,5}, 11);
        System.out.println(res);
    }
}
