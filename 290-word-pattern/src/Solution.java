import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (strs.length != pattern.length()) return false;
        String[] resultStrs = new String[pattern.length()];
        HashMap<Character, String> hm = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (hm.get(c) == null) {
                //pattern中不同的规则，不能对应相同的str中的值。
                if (hm.containsValue(strs[i])) {
                    return false;
                }
                hm.put(c, strs[i]);
            }
            resultStrs[i] = hm.get(c);
        }
        //数组是否相等
        return Arrays.equals(strs, resultStrs);
    }

    public static void main(String[] args) {
        String pattern = "abba", str = "dog dog dog dog";
        System.out.println(new Solution().wordPattern(pattern, str));
    }
}
