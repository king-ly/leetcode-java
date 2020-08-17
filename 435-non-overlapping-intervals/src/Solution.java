import java.util.Arrays;

/**
 * 动态规划最长子序列
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        //二维数组排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        //将这个变成最长子序列问题
        int[] memo = new int[intervals.length];
        Arrays.fill(memo, 1);
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[i][0] >= intervals[j][1]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
        }
        return intervals.length - Arrays.stream(memo).max().getAsInt();
    }

    public static void main(String[] args) {
//        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int[][] intervals = {{1, 2}, {1, 2}, {1, 2}};
        System.out.println(new Solution().eraseOverlapIntervals(intervals));

    }
}
