import java.util.*;

public class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        brackTrace(nums, 0, new ArrayDeque<>());
        return res;
    }

    private void brackTrace(int[] nums, int start, Deque<Integer> path) {
        if (nums.length < path.size()) {
            return;
        }
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.addLast(nums[i]);
            brackTrace(nums, i + 1, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = new Solution().subsets(nums);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
