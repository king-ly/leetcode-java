import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    //滑动窗口
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = -1, len = 0; // [l...r]
        Set<Character> set = new HashSet<>();
        while (l < s.length()) {
            //先处理向右滑动的情况
            if (r + 1 < s.length() && !set.contains(s.charAt(r + 1))) {
                r++;
                set.add(s.charAt(r));
            } else {
                set.remove(s.charAt(l));
                l++;
            }
            len = Math.max(len, r - l + 1);
        }
        return len;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new Solution().lengthOfLongestSubstring(s));

    }
}
