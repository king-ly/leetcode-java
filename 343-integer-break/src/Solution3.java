//动态规划法
public class Solution3 {

    public int integerBreak(int n) {
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                nums[i] = max3(nums[i], j * (i - j), j * nums[i - j]);
            }
        }
        return nums[n];
    }


    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }


    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Solution3().integerBreak(n));
    }
}
