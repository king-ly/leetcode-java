import java.util.Arrays;

//超出时间限制
//递归算法，从前向后的过程
//Solution2为从后向前
public class Solution {

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        return bestValue(nums, 0, sum / 2);
    }

    private boolean bestValue(int[] nums, int start, int c) {
        if (c == 0) {
            return true;
        } else if (c < 0 || start >= nums.length) {
            return false;
        }
        for (int i = start; i < nums.length; i++) {
                boolean flag = bestValue(nums, i + 1, c - nums[i]);
                if (flag == true) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5};
        System.out.println(new Solution().canPartition(nums));
    }

}
