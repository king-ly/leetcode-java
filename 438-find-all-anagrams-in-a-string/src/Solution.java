import java.util.*;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        char[] x = p.toCharArray();
        Arrays.sort(x);         //变成有顺序
        List<Integer> lists = new ArrayList<>();
        int l = 0, r = p.length() - 1;
        while (r < s.length()) {  //substring截取，不包含最后的位置，所以要r+1
            char[] y = s.substring(l, r + 1).toCharArray();
            Arrays.sort(y);
            if (Arrays.equals(x, y)) {
                lists.add(l);
            }
            l++;
            r++;
        }
        return lists;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> repose = new Solution().findAnagrams(s, p);
        System.out.println(repose.toString());
    }
}
