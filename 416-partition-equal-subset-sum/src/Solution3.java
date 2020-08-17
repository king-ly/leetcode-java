import java.util.Arrays;

//动态规划，背包问题
public class Solution3 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 0; i <= sum; i++) {
            dp[0][i] = (nums[0] == i);
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j > nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][sum];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5};
        System.out.println(new Solution3().canPartition(nums));
    }
}
