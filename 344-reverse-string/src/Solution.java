import java.util.Arrays;

public class Solution {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (r > l) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }

    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        new Solution().reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
