import java.util.*;
import java.util.stream.Collectors;

/**
 * 回溯算法
 */
public class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

    public int rob(int[] nums) {
        brackTrace(nums, 0, new ArrayDeque<>());
        for (List<Integer> list : res) {
            pq.add(list.stream().collect(Collectors.summingInt(Integer::intValue)));
        }
        return pq.peek();
    }

    private void brackTrace(int[] nums, int start, Deque<Integer> path) {
        if (nums.length <= start) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            path.addLast(nums[i]);
            brackTrace(nums, i + 2, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new Solution().rob(nums));
    }
}
