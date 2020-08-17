public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        //dp代表每天三种状态下的资产情况
        int[][] dp = new int[prices.length][3];
        dp[0][0] = 0;           //表示不持股(1、昨天不持股 2、昨天持股，今天卖了一股)
        dp[0][1] = -prices[0];  //表示持股；（1、昨天冷冻期，今天买了一股  2、昨天持股，今天不动）
        dp[0][2] = 0;           //表示处在冷冻期 （1、昨天卖了一股，也就是昨天不持股，今天就是冷冻期）
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][1]);
            dp[i][2] = dp[i - 1][0];
        }
        //最后一天不能持股，只能处理0-不持股  2-冷冻期
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(new Solution().maxProfit(prices));
    }
}
