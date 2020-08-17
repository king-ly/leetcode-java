import java.util.*;

public class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        brackTrace(nums, 0, new ArrayDeque<>());
        return res;
    }

    private void brackTrace(int[] nums, int start, Deque<Integer> path) {
        if (nums.length < path.size()) {
            return;
        }
        List<Integer> list = new ArrayList<>(path);
        list.sort((a, b) -> a - b);
        if (!res.contains(list)) {
            res.add(list);
        }

        for (int i = start; i < nums.length; i++) {
            path.addLast(nums[i]);
            brackTrace(nums, i + 1, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = new Solution().subsetsWithDup(nums);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
