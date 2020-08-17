import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public boolean isHappy(int n) {
        HashSet set = new HashSet();
        while (n != 1) {
            String newNum = String.valueOf(n);
            int sum = 0;
            for (int i = 0; i < newNum.length(); i++) {
                int tmp = Integer.valueOf(newNum.charAt(i)) - 48;   //因为为string之后就变成 1->'1'(49)
                sum = sum + (int) Math.pow(tmp, 2);
            }
            if (sum == 1) {
                return true;
            } else if (set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
                n = sum;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
        int n = 19;
        System.out.println(new Solution().isHappy(n));
    }
}
