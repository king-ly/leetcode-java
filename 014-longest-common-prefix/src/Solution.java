/**
 * 14. 最长公共前缀
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        //1、处理特殊情况
        if (strs == null || strs.length == 0) {
            return "";
        }
        //以strs[0]为参照点。从0位开始至strs[0].length(),依次对比
        for (int prefix = 0; prefix < strs[0].length(); prefix++) {
            //取出数组的其它位置值
            for (int i = 1; i < strs.length; i++) {
                //当prefix参照位置 >= 当前数组的length,说明当前数组没有位置
                //当数组的位置和strs[0]的值不一致时，返回退出。
                if (strs[i].length() <= prefix || strs[0].charAt(prefix) != strs[i].charAt(prefix)) {
                    return strs[0].substring(0, prefix);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
//        String[] strs = new String[]{"flower","flow","flight"};
        String[] strs = new String[]{"aa","a"};
        System.out.println(new Solution().longestCommonPrefix(strs));
    }
}