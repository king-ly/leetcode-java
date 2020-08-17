import java.util.Arrays;

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[] nums1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] nums2 = Arrays.copyOfRange(nums, 1, nums.length);
        return Math.max(tryRob(nums1, 0, new Integer[nums1.length + 1]), tryRob(nums2, 0, new Integer[nums2.length + 1]));
    }

    private int tryRob(int[] nums, int index, Integer[] memo) {
        if (index > nums.length) {
            return 0;
        }
        if (memo[index] == null) {
            int res = 0;
            for (int i = index; i < nums.length; i++) {
                res = Math.max(res, nums[i] + tryRob(nums, i + 2, memo));
            }
            memo[index] = res;
        }
        return memo[index];
    }

    public static void main(String[] args) {
        int[] nums = {4, 3};
        System.out.println(new Solution().rob(nums));
    }
}
