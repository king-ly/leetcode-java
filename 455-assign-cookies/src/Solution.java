import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        //最贵的饼干给最贪心的小朋友
        for (int i = s.length - 1, j = g.length - 1; i >= 0 && j >= 0; ) {
            if (s[i] >= g[j]) {
                i--;
                j--;
                res++;
            } else {
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        System.out.println(new Solution().findContentChildren(g, s));
    }
}
