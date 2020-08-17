//递归算法
public class Solution {
    private int count;

    public int combinationSum4(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        tryCombination(nums, target);
        return count;
    }

    private void tryCombination(int[] nums, int target) {
        if (target == 0) {
            count++;
            return;
        } else if (target < 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            tryCombination(nums, target - nums[i]);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3};
        int target = 35;
        System.out.println(new Solution().combinationSum4(nums, target));
    }
}
