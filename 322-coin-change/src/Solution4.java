import java.util.Arrays;

//动态规划
public class Solution4 {

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            //每个dp[i] 下面都可能有coins.length的分解情况
            //比较每次的分解情况，取最小值
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    //dp中的每个值每次都可能变化
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
        System.out.println(new Solution4().coinChange(coins, amount));
    }
}
