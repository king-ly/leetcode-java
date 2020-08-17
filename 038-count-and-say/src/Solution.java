/**
 * 38. 外观数列
 * 这里面没有给出来N=6的情况，所以没有找到规律。也就是说给出来的情况越多，越容易找到规律
 */
public class Solution {

    public String countAndSay(int n) {
        String say = "1";
        for (int i = 2; i <= n; i++) {
            StringBuffer res = new StringBuffer();
            for (int j = 0; j < say.length(); j++) {
                int repeatCount = 1;
                while (j + 1 <= say.length() - 1 && say.charAt(j) == say.charAt(j + 1)) {
                    j++;
                    repeatCount++;
                }
                if (repeatCount > 1) {
                    res.append(repeatCount).append(say.charAt(j));
                } else {
                    res.append(getChange(say.substring(j, j + 1)));
                }
            }
            say = res.toString();
        }
        return say;
    }

    private String getChange(String x) {
        return "1" + x;
    }

    public static void main(String[] args) {
        int n = 7;
        System.out.println(new Solution().countAndSay(n));
    }
}
