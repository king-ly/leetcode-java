public class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (r > l) {
            char x = Character.toLowerCase(s.charAt(l));
            char y = Character.toLowerCase(s.charAt(r));
            if (x == y) {
                l++;
                r--;
            } else if (!(x >= '0' && x <= '9') && !(x >= 'a' && x <= 'z')) {
                l++;
            } else if (!(y >= '0' && y <= '9') && !(y >= 'a' && y <= 'z')) {
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "race a car";
        System.out.println(new Solution().isPalindrome(s));
    }
}
