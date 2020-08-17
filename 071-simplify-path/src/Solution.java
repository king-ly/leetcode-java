import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] strs = path.split("/");
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (str.equals("") || str.equals(".")) {
                //为 . 时不用处理
            } else {
                stack.add(str);
            }
        }
        StringBuffer res = new StringBuffer();
        while (!stack.isEmpty()) {
            res.append("/" + stack.remove(0));
        }

        return res.length() == 0 ? "/" : res.toString();
    }

    public static void main(String[] args) {
        String path = "/../";
        System.out.println(Arrays.toString(path.split("/")));
        System.out.println(new Solution().simplifyPath(path));
    }
}
