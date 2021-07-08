// lc 322 复习的时候看dp解法即可
import java.util.*;
public class CoinChange {
    // dfs + greedy + pruning
    // https://www.youtube.com/watch?v=uUETHdijzkA&t=305s&ab_channel=HuaHua
    // time O(amount^n / (coin_1 * coin_2 * ... * coin_n))
    // 一共有n层递归，每一层的循环的上限是 amount / coin_i
    // 所以就是 (amount / coin_1) *  (amount / coin_2) * ... (amount / coin_n)
    // 递归展开后大概是这样...
    // for (int i1 = 1; i1 <= amount / coin_1; ++i1)
    //   for (int i2 = 1; i2 <= amount / coin_2; ++i2)
    //     for (int i3 = 1; i2 <- amount / coin_3; ++i3)
    //       ...
    private int minCount;
    public int coinChange2(int[] coins, int amount) {
        minCount = amount + 1;
        Integer[] coinsObj = new Integer[coins.length];
        for (int i = 0; i < coins.length; i++) {
            coinsObj[i] = coins[i];
        }
        Arrays.sort(coinsObj, (a, b) -> b.compareTo(a));
        dfs(coinsObj, amount, 0, 0);
        return minCount == amount + 1 ? -1 : minCount;
    }

    private void dfs(Integer[] coinsObj, int amount, int count, int start) {
        if (amount == 0) {
            minCount = Math.min(minCount, count);
            return;
        }
        if (start >= coinsObj.length) return;
        int coin = coinsObj[start];
        for (int k = amount / coin; k >= 0 && count + k < minCount; k--) {
            dfs(coinsObj, amount - k * coin, count + k, start + 1);
        }
    }

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
        int res = s.coinChange(new int[]{484,395,346,103,329}, 4259);
        System.out.println(res);
    }
}
