import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int l = stack.pop();
                int r = stack.pop();
                if (tokens[i].equals("+")) {
                    stack.add(l + r);
                } else if (tokens[i].equals("-")) {
                    stack.add(r - l);
                } else if (tokens[i].equals("*")) {
                    stack.add(l * r);
                } else {
                    stack.add(r / l);
                }
            } else {
                stack.add(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new Solution().evalRPN(tokens));
    }
}
