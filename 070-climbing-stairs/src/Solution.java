public class Solution {
    //递归写法
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        if (n < 3) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    //动态规划写法
    public int climbStairs2(int n) {
        //这里多初始化几个长度。因为dp[0],dp[1],dp[2]这三个都要用到。
        int[] dp = new int[n + 3];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(new Solution().climbStairs2(n));
    }
}
