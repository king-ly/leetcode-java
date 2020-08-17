class Solution {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int x = -1;
        System.out.println(new Solution().isPalindrome(x));
    }
}