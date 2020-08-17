public class Solution {
    public int maxSubArray(int[] nums) {
        int x = 0, y = 0, sum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int tmpSum = 0;
            for (int j = i; j < nums.length; j++) {
                tmpSum = tmpSum + nums[j];
                if (tmpSum > sum) {
                    x = i;
                    y = j;
                    sum = tmpSum;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(new Solution().maxSubArray(nums));
    }
}
