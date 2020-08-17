//递归方式+记忆化搜索
public class Solution4 {
    private Integer[] memo;

    public int rob(int[] nums) {
        memo = new Integer[nums.length];
        return tryRob(nums, 0);
    }

    private int tryRob(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (memo[index] == null) {
            int res = 0;
            for (int i = index; i < nums.length; i++) {
                res = Math.max(res, nums[i] + tryRob(nums, i + 2));
            }
            memo[index] = res;
        }
        return memo[index];
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2};
        System.out.println(new Solution4().rob(nums));
    }
}
