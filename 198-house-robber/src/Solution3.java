//递归方式
public class Solution3 {
    public int rob(int[] nums) {
        return tryRob(nums, 0);
    }

    private int tryRob(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + tryRob(nums, i + 2));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2};
        System.out.println(new Solution3().rob(nums));
    }
}
