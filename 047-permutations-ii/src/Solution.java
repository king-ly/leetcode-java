import java.util.*;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        backtrack(nums, new ArrayDeque<>(), new ArrayDeque<>());
        return res;
    }

    //使用坐标法。如果位置坐标使用过一次，就不再使用
    private void backtrack(int[] nums, Deque<Integer> cur, Deque<Integer> path) {
        if (nums.length == path.size()) {
            //值去重
            List<Integer> list = new ArrayList<>(path);
            if (!res.contains(list)) {
                res.add(list);
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //果位置坐标使用过一次，就不再使用
            if (cur.contains(i)) {
                continue;
            }
            cur.addLast(i);
            path.addLast(nums[i]);
            backtrack(nums, cur, path);
            cur.removeLast();
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> res = new Solution().permuteUnique(nums);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
