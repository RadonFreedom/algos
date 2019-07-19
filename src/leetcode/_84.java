package leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author xufeng
 * created at 2019.07.16 09:18
 */

public class _84 {

    public int largestRectangleArea(int[] heights) {

        Stack<Integer> l = new Stack<>();
        int res = 0;
        //dummy
        l.add(-1);
        /*
        height递增时入栈
         */
        for (int i = 0; i < heights.length; i++) {
            //如果出现递减的情况
            while (l.size() > 1 && heights[l.peek()] > heights[i]) {
                int j = l.pop();
                res = Math.max((i - l.peek() - 1) * heights[j], res);
            }
            l.add(i);
        }

        while (l.size() > 1) {
            int j = l.pop();
            res = Math.max((heights.length - l.peek() - 1) * heights[j], res);
        }

        return res;
    }
}
