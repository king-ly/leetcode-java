import java.util.*;

public class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        Deque<Integer> path = new ArrayDeque<>();
        backtrack(nums, path);
        return res;
    }

    private void backtrack(int[] nums, Deque<Integer> path) {
        if (nums.length == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.addLast(nums[i]);
            backtrack(nums, path);
            System.out.println(Arrays.toString(path.toArray()));
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = new Solution().permute(nums);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
