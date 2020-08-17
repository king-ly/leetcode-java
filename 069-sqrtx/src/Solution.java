public class Solution {
    public int mySqrt(int x) {
        return (int)Math.floor(Math.sqrt(x));
    }

    public static void main(String[] args) {
        int x = 8;
        System.out.println(new Solution().mySqrt(x));
    }
}
