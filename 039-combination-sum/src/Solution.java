import java.util.*;
import java.util.stream.Collectors;

/**
 * 	56 ms
 */
public class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0, new ArrayDeque<>());
        return res;
    }

    private void backtrack(int[] candidates, int target, int start, Deque<Integer> path) {
        int sum = path.stream().collect(Collectors.summingInt(Integer::intValue));
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        } else if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            backtrack(candidates, target, i, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = new Solution().combinationSum(candidates, target);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
