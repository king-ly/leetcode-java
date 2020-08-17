import java.util.*;
import java.util.stream.Collectors;

/**
 * 3 ms
 */
public class Solution2 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayDeque<>());
        return res;
    }

    private void backtrack(int[] candidates, int target, int start, Deque<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                path.addLast(candidates[i]);
                backtrack(candidates, target - candidates[i], i, path);
                path.removeLast();
            } else {
                //break;  //如果排序了，可以使用break跳出
                continue;
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {8, 7, 4, 3};
        int target = 11;
        List<List<Integer>> res = new Solution2().combinationSum(candidates, target);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
