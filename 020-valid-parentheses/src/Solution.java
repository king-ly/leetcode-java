import java.util.Stack;

/**
 * 20. 有效的括号
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int validNum = getValue(s.charAt(i));
            if (validNum == 0) return false;
            if (validNum > 0) {
                stack.add(s.charAt(i));
            } else {
                if (stack.isEmpty() != false || getValue(stack.pop()) + validNum != 0) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private int getValue(char c) {
        switch (c) {
            case '(':
                return 1;
            case '[':
                return 2;
            case '{':
                return 3;
            case ')':
                return -1;
            case ']':
                return -2;
            case '}':
                return -3;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
//        String s = "()[]{}";
        String s = "{[]}";
//        String s = "[";
//        String s = "]";
        System.out.println(new Solution().isValid(s));
    }
}
