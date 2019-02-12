package sword;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=13&tqId=11173&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.01.30 11:28
 */

public class _25 {

    private Stack<Integer> stack = new Stack<>();
    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public void push(int node) {
        stack.push(node);
        priorityQueue.add(node);
    }

    public void pop() {
        priorityQueue.remove(stack.pop());
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return priorityQueue.peek();
    }
}
