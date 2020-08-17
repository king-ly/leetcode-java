import java.util.*;

public class Solution {
    private List<List<String>> res = new ArrayList<>();


    public List<List<String>> partition(String s) {
        Deque<String> path = new ArrayDeque<>();
        backtracking(s, 0, s.length(), path);
        return res;
    }

    private void backtracking(String s, int start, int len, Deque<String> path) {
        System.out.println(s + " : " + start + " : " + Arrays.toString(path.toArray()));
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < len; i++) {
            if (!checkPalindrome(s.substring(start, i + 1))) {
                continue;
            }
            path.addLast(s.substring(start, i + 1));
            backtracking(s, i + 1, len, path);
            path.removeLast();
        }
        return;
    }

    private boolean checkPalindrome(String s) {
        StringBuffer sb = new StringBuffer(s);
        String rs = sb.reverse().toString();
        return s.equals(rs);
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> lists = new Solution().partition(s);
        System.out.println(Arrays.toString(lists.toArray()));
    }
}
