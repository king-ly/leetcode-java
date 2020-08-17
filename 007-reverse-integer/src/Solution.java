import com.sun.xml.internal.ws.util.StringUtils;

public class Solution {
    public int reverse(int x) {
        String y = String.valueOf(x);
        StringBuffer z = new StringBuffer();
        for (int i = y.length() - 1; i >= 0; i--) {
            if (y.charAt(i) != '-') {
                z.append(y.charAt(i));
            }
        }
        try {
            Integer s = Integer.valueOf(z.toString());
            if (x < 0) {
                s = s * -1;
            }
            return s;
        }catch (Exception e){
            return 0;
        }

    }

    public static void main(String[] args) {
        int y = new Solution().reverse(1534236462);
        System.out.println(y);

    }
}
