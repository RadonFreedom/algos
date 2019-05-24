package sword;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tqId=11158&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * @author Radon Freedom
 * created at 2019.01.22 9:12
 */

public class _1 {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {

        stack1.push(node);
    }

    public int pop() {

        if (stack2.empty()) {
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public String replaceSpace(StringBuffer str) {

        return str.toString().replace(" ", "%20");
    }

    public static void main(String[] args) {
        _1 queue = new _1();

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.pop();
        queue.pop();
        queue.push(4);
        queue.pop();
        queue.push(5);
        queue.pop();
        queue.pop();
    }
}
