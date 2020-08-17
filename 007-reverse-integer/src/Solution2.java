public class Solution2 {
    public int reverse(int x) {
        if (Math.pow(2, 31)-1 < x || -1*Math.pow(2, 31) >x){
            return 0;
        }
        int r = 0;
        while (x != 0){
            int pop = x % 10;
            x = x /10;
            r = r * 10 + pop;
        }
        return r;
    }

    public static void main(String[] args) {
        int x = 123;
        int r = new Solution2().reverse(x);
        System.out.println(r);

    }
}
