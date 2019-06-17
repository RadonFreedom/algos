package leetcode;

import java.util.Stack;

/**
 * @author Radon Freedom
 * created at 2019.06.17 15:53
 */

public class _155 {

    class MinStack {

        /**
         * 存储着栈当前的最小值，也是{@link #getMin()}返回值
         */
        int min = Integer.MAX_VALUE;

        Stack<Integer> stack = new Stack<>();

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {

            /*
            如果此时min变化，将前一个阶段的min值入栈，更新min值
            这里必须带上等号，否则新入栈的值将会造成下次pop弹出2个有效入栈值
             */
            if (min >= x) {
                stack.push(min);
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            if (stack.isEmpty()) return;

            /*
            从push()方法取逆
            如果当前阶段的min值就是栈顶，说明上一阶段的min值是下一个栈顶
             */
            if (min == stack.pop()) {
                min = stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new _155().new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        minStack.pop();
    }
}
