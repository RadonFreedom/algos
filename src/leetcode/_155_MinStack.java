package leetcode;

import java.util.Stack;

/**
 * @author Radon Freedom
 * created at 2019.05.04 下午5:57
 */

public class _155_MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();

    public void push(int x) {
        // only push the old minimum value when the current
        // minimum value changes after pushing the new value x
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value,
        // pop twice and change the current minimum value to the last minimum value.
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        _155_MinStack stack = new _155_MinStack();
        stack.push(1);
        stack.push(2);
        stack.push(0);
        stack.pop();
        stack.pop();
        stack.pop();
    }
}
