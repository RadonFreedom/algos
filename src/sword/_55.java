package sword;

import java.util.PriorityQueue;

/**
 * @author Radon Freedom
 * created at 2019.02.16 11:30
 */

public class _55 {


    private PriorityQueue<Integer> lo = new PriorityQueue<>((i, j) -> Integer.compare(0, i.compareTo(j)));
    private PriorityQueue<Integer> hi = new PriorityQueue<>();
    private int size = 0;

    public void Insert(Integer num) {
        if (lo.peek() != null && num < lo.peek()) {
            lo.add(num);
        }
        else {
            hi.add(num);
        }
        size++;
        balance();
    }

    public Double GetMedian() {
        if (size == 0) {
            return null;
        }
        if (size % 2 == 0) {
            return (lo.peek() + hi.peek()) / 2.0;
        }
        else {
            return Double.valueOf(hi.peek());
        }
    }

    private void balance(){
        while (hi.size() > lo.size() + 1) {
            lo.add(hi.poll());
        }
        while (hi.size() < lo.size()) {
            hi.add(lo.poll());
        }
    }

    public static void main(String[] args) {
        Integer[] ints = new Integer[]{5,2,3,4,1,6,7,0,8};
        _55 solution = new _55();
        for (int i = 0; i < ints.length; i++) {
            solution.Insert(ints[i]);
            System.out.println(solution.GetMedian() + " ");
        }
    }
}
