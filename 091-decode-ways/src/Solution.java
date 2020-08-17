import java.util.*;

public class Solution {
    private List<List<String>> res = new ArrayList<>();

    public int numDecodings(String s) {
        brackTrace(s, 0, new ArrayDeque<>());
        System.out.println(Arrays.toString(res.toArray()));
        return res.size();
    }

    private void brackTrace(String s, int start, Deque<String> path) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            path.addLast(String.valueOf(s.charAt(i)));
            brackTrace(s.substring(i), i, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        String s = "12";
        System.out.println(new Solution().numDecodings(s));
    }
}
