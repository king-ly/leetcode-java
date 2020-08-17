import java.util.*;

//回溯算法
public class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public int coinChange(int[] coins, int amount) {
        brackTrace(coins, amount, new ArrayDeque<>());
        System.out.println(Arrays.toString(res.toArray()));
        return 0;
    }

    private void brackTrace(int[] coins, int amount, Deque<Integer> path) {
        if (amount == 0) {
            res.add(new ArrayList<>(path));
            return;
        } else if (amount < 0) {
            return;
        }
        for (int i = 0; i < coins.length; i++) {
            path.addLast(coins[i]);
            brackTrace(coins, amount - coins[i], path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(new Solution().coinChange(coins, amount));
    }
}
