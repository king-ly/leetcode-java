import java.util.*;

public class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayDeque<>());
        return res;
    }

    private void backtrack(int[] candidates, int target, int start, Deque<Integer> path) {
        if (target == 0) {
            List<Integer> list = new ArrayList<>(path);
            list.sort((a, b) -> a - b);
            if (!res.contains(list)) {
                res.add(list);
            }
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                path.addLast(candidates[i]);
                backtrack(candidates, target - candidates[i], i + 1, path);
                path.removeLast();
            } else {
                continue;
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 5, 2, 1, 2};
        int target = 5;
        List<List<Integer>> res = new Solution().combinationSum2(candidates, target);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
