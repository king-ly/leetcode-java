/**
 * 字符串截取
 */
public class Solution {

//    public int strStr(String haystack, String needle) {
//        if (needle == null || "".equals(needle)) return 0;
//        for (int i = 0; i < haystack.length(); i++) {
//            //只要haystack的位置与needle的第一个字母相等就可能重复，进入比较
//            if (haystack.charAt(i) == needle.charAt(0)) {
//                for (int j = i, k = 0; j < haystack.length(); j++,k++) {
//                    if (haystack.charAt(j) != needle.charAt(k)) {
//                        break;
//                    }
//                    if (k == needle.length() - 1) return i;
//                }
//            }
//        }
//        return -1;
//    }

    /**
     * 使用字符串截取的方式，更加方便
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        for (int i = 0; i < haystack.length() - len + 1; i++) {
            if (haystack.substring(i, i + len).equals(needle))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "aaaaa", needle = "bba";
        System.out.println(new Solution().strStr(haystack, needle));
    }
}
