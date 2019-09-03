package leetcode;

import java.util.Stack;

/**
 * @author Radon Freedom
 * created at 2019.06.17 15:53
 */

public class _155 {
    class MinStack {

        int min = Integer.MAX_VALUE;
        Stack<Integer> s = new Stack<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        /**
         * 我们把每个阶段的最小值存储在min中
         * 如果有更小的值出现，则把前一个最小值push进栈
         * 注意到上一个min值永远在本个min值所在栈单元下面存储
         */
        public void push(int x) {
            // 取等号，避免出现x == min导致pop掉2个实际值的情况
            if (x <= min) {
                s.push(min);
                min = x;
            }
            s.push(x);
        }

        /**
         * 我们需要在刚pop出的值等于min时再pop出上一个min值
         */
        public void pop() {
            if (s.pop() == min) {
                min = s.pop();
            }
        }

        public int top() {
            return s.peek();
        }

        public int getMin() {
            return min;
        }
    }
}
