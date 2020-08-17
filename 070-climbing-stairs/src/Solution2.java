import java.util.Arrays;

/**
 * 递归写法
 */
public class Solution2 {
    private int[] nums;

    public int climbStairs(int n) {
        nums = new int[n + 1];
        Arrays.fill(nums, -1);
        return climbing(n);

    }

    private int climbing(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        if (nums[n] == -1) {
            nums[n] = climbing(n - 1) + climbing(n - 2);
        }
        return nums[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(new Solution2().climbStairs(n));
    }
}
