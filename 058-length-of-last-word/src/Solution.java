public class Solution {
    public int lengthOfLastWord(String s) {
        String[] arrs = s.split(" ");
        if (arrs.length > 0)
            return arrs[arrs.length - 1].length();
        else return 0;
    }

    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println(new Solution().lengthOfLastWord(str));
    }
}
