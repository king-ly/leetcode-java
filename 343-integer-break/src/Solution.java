import java.util.*;
import java.util.stream.Collectors;

//使用回溯算法，超时
public class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

    public int integerBreak(int n) {
        brackTrace(n, new ArrayDeque<>());
        System.out.println(Arrays.toString(res.toArray()));
        for (List<Integer> list : res) {
            pq.add(list.stream().collect(Collectors.reducing(Math::multiplyExact)).get());
        }
        return pq.poll();
    }

    private void brackTrace(int n, Deque<Integer> path) {
        if (n == 0 && path.size() >= 2) {
            res.add(new ArrayList<>(path));
            return;
        } else if ((n == 0 && path.size() < 2) || n < 0) {
            return;
        }
        for (int i = 1; i <= n; i++) {
            path.addLast(i);
            brackTrace(n - i, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Solution().integerBreak(n));
    }
}
