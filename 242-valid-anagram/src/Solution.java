import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int size = hm.get(c) == null ? 0 : hm.get(c);
            hm.put(c, size + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int size = hm.get(c) == null ? 0 : hm.get(c);
            if (size == 0) {
                return false;
            } else {
                hm.put(c, size - 1);
            }
        }
        int sum = hm.values().stream().collect(Collectors.summingInt(Integer::intValue));
        return sum == 0 ? true : false;
    }

    public static void main(String[] args) {
        String s = "anagram1", t = "nagaram";
        boolean flag = new Solution().isAnagram(s, t);
        System.out.println(flag);
    }
}
