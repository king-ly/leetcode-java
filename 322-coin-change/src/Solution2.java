//递归
public class Solution2 {
    private int minCount = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        brackTrace(coins, amount, 0);
        return minCount;
    }

    private void brackTrace(int[] coins, int amount, int count) {
        if (amount == 0) {
            minCount = Math.min(minCount, count);
            return;
        } else if (amount < 0) {
            return;
        }
        for (int i = 0; i < coins.length; i++) {
            brackTrace(coins, amount - coins[i], count + 1);
        }
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(new Solution2().coinChange(coins, amount));
    }
}
