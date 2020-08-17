import java.util.Arrays;

/**
 * 贪心算法
 */
public class Solution2 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        //二维数组排序。把结尾排序
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int pre = 0;
        int cnt = 1;
        for (int i = 1; i < intervals.length; i++) {
            //如果当前的start >= 前一个位置的 end
            if (intervals[i][0] >= intervals[pre][1]) {
                pre = i;
                cnt++;
            }
        }
        return intervals.length - cnt;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
//        int[][] intervals = {{1, 2}, {1, 2}, {1, 2}};
        System.out.println(new Solution2().eraseOverlapIntervals(intervals));

    }
}
