//递归法
public class Solution2 {
    private Integer[] nums;

    public int integerBreak(int n) {
        nums = new Integer[n + 1];
        return brackTrace(n);
    }

    private int brackTrace(int n) {
        if (n == 1) {
            return 1;
        }
        if (nums[n] == null) {
            int res = -1;
            for (int i = 1; i <= n - 1; i++) {
                res = max3(res, i * (n - i), i * brackTrace(n - i));
            }
            nums[n] = res;
        }
        return nums[n];
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }


    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Solution2().integerBreak(n));
    }
}
