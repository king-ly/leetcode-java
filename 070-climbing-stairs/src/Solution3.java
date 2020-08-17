public class Solution3 {
    public int climbStairs(int n) {
        int[] nums = new int[n + 1];
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        nums[1] = 1;
        nums[2] = 2;
        for (int i = 3; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(new Solution3().climbStairs(n));
    }

}
