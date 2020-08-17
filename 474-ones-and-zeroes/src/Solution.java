import java.util.Arrays;

public class Solution {
    private int count = 0;

    public int findMaxForm(String[] strs, int m, int n) {
        tryFind(strs, 0, m, n, 0);
        return count;
    }

    private void tryFind(String[] strs, int index, int m, int n, int cnt) {
        if (m == 0 && n == 0) {
            count = Math.max(count, cnt);
            return;
        } else if (index >= strs.length || (m < 0 && n < 0)) {
            return;
        }

        for (int i = index; i < strs.length; i++) {
            tryFind(strs, i + 1, m - hasCode(strs[i], '0'), n - hasCode(strs[i], '1'), cnt + 1);
        }
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
        String[] strs = {"10", "0", "1"};
        int m = 1, n = 1;
        System.out.println(new Solution().findMaxForm(strs, m, n));
    }
}
