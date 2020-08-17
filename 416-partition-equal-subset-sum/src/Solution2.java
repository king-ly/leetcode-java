import java.util.Arrays;

/**
 * 递归算法
 */
public class Solution2 {
    private Boolean[][] memo;

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        memo = new Boolean[nums.length][sum + 1];
        return tryPartition(nums, nums.length - 1, sum / 2);
    }

    //递归算法，是从数组的最后向前找，然后结果从前往后返回
    //是否可以填充
    private boolean tryPartition(int[] nums, int index, int sum) {
        if (sum == 0) {
            return true;
        } else if (sum < 0 || index < 0) {
            return false;
        }
        if (memo[index][sum] == null) {
            memo[index][sum] = tryPartition(nums, index - 1, sum) || tryPartition(nums, index - 1, sum - nums[index]);
        }
        return memo[index][sum];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        System.out.println(new Solution2().canPartition(nums));
    }
}

