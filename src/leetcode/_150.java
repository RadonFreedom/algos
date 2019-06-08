package leetcode;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author Radon Freedom
 * created at 2019.06.08 16:22
 */

public class _150 {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        HashSet<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");

        for (int i = 0; i < tokens.length; i++) {
            if (set.contains(tokens[i])) {

                int b = stack.pop();
                int a = stack.pop();
                if ("+".equals(tokens[i])) {
                    stack.push(a + b);
                } else if ("-".equals(tokens[i])) {
                    stack.push(a - b);
                } else if ("*".equals(tokens[i])) {
                    stack.push(a * b);
                } else {
                    stack.push(a / b);
                }

            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        new _150().evalRPN(new String[]{"2","1","+","3","*"});
    }
}
