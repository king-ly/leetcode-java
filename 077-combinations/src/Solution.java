import java.util.*;

public class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1, new LinkedList<>());
        return res;
    }

    private void backtrack(int n, int k, int cur, LinkedList<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = cur; i <= n - (k - path.size()) + 1; i++) {
            path.addLast(i);
            backtrack(n, k, i + 1, path);
            path.removeLast();
        }
        return;
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> res = new Solution().combine(n, k);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
