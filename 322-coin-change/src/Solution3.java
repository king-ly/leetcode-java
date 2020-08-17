//记忆化搜索
public class Solution3 {
    private Integer[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new Integer[amount];
        return brackTrace(coins, amount);
    }

    private int brackTrace(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        } else if (amount < 0) {
            return -1;
        }
        if (memo[amount - 1] != null) {
            return memo[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = brackTrace(coins, amount - coins[i]);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        return memo[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(new Solution3().coinChange(coins, amount));
    }
}
