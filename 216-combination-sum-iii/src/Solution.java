import java.util.*;

public class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        brackTrace(k, n, 1, new ArrayDeque<>());
        return res;
    }

    private void brackTrace(int k, int n, int start, Deque<Integer> path) {
        if (k == path.size() && n == 0) {
            res.add(new ArrayList<>(path));
            return;
        } else if (k == path.size() && n != 0) {
            return;
        }
        for (int i = start; i < 10; i++) {
            //优化
            if (i > n) {
                break;
            }
            path.addLast(i);
            brackTrace(k, n - i, i + 1, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int k = 3, n = 9;
        List<List<Integer>> res = new Solution().combinationSum3(k, n);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
