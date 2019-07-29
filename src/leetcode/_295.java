package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author xufeng
 * created at 2019.07.27 12:12
 */

public class _295 {

    private PriorityQueue<Integer> min = new PriorityQueue<>(Comparator.reverseOrder());
    private PriorityQueue<Integer> max = new PriorityQueue<>();

    public void addNum(int num) {
        if (min.size() > max.size()) {
            if (num < min.peek()) {
                max.add(min.poll());
                min.add(num);
            } else {
                max.add(num);
            }
        } else {
            if (!max.isEmpty() && num > max.peek()) {
                min.add(max.poll());
                max.add(num);
            } else {
                min.add(num);
            }
        }
    }

    public double findMedian() {
        if (min.size() > max.size()) {
            return min.peek();
        } else {
            return (min.peek() + max.peek()) / 2.0;
        }
    }
}
