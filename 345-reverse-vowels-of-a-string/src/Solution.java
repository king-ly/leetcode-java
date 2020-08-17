import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] c = s.toCharArray();
        int l = 0, r = c.length - 1;
        while (r > l) {
            char x = c[l];
            char y = c[r];
            if (set.contains(x) && set.contains(y)) {
                char tmp = c[l];
                c[l] = c[r];
                c[r] = tmp;
                l++;
                r--;
            } else if (set.contains(x)) {
                r--;
            } else {
                l++;
            }
        }
        return String.valueOf(c);
    }

    public static void main(String[] args) {
        String str = "leetcode";
        System.out.println(new Solution().reverseVowels(str));
    }
}
