public class Solution2 {
    private Integer[][][] memo;

    public int findMaxForm(String[] strs, int m, int n) {
        memo = new Integer[strs.length][m + 1][n + 1];
        return tryFind(strs, 0, m, n);
    }

    private int tryFind(String[] strs, int index, int m, int n) {
        if ((m == 0 && n == 0) || (index == strs.length && m >= 0 && n >= 0)) {
            return 0;
        } else if (index >= strs.length || m < 0 || n < 0) {
            return -1;
        }

        if (memo[index][m][n] != null) {
            return memo[index][m][n];
        }
        for (int i = index; i < strs.length; i++) {
            int res = tryFind(strs, i + 1, m - hasCode(strs[i], '0'), n - hasCode(strs[i], '1'));
            //递归到底往回返的时候++
            if (res >= 0) {
                memo[index][m][n] = Math.max(memo[index][m][n] == null ? 0 : memo[index][m][n], res + 1);
            }
        }
        return memo[index][m][n] == null ? 0 : memo[index][m][n];
    }

    private int hasCode(String str, char c) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] strs = {"00","000"};
        int m = 1, n = 10;
        System.out.println(new Solution2().findMaxForm(strs, m, n));
    }
}
