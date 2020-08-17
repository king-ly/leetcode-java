import java.util.Arrays;

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = -1, len = nums.length + 1;
        int sum = 0;
        while (l < nums.length) {
            if (sum < s && r + 1 < nums.length) {
                r++;
                sum = sum + nums[r];
            } else {
                sum = sum - nums[l];
                l++;
            }
            if (sum >= s) {
                len = Math.min(len, r - l + 1);
            }
        }
        return len == nums.length + 1 ? 0 : len;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println(new Solution().minSubArrayLen(s, nums));
    }
}
