import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] y = t.toCharArray();
        char[] x = new char[s.length()];
        HashMap<Character, Character> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hm.get(c) == null) {
                //处理 s="ab" t="aa" 情况
                if (hm.containsValue(y[i])){
                    return false;
                }
                hm.put(c, y[i]);
            }
            x[i] = hm.get(c);
        }
        return Arrays.equals(x, y);
    }

    public static void main(String[] args) {
        String s = "ab", t = "aa";
        System.out.println(new Solution().isIsomorphic(s, t));
    }
}
