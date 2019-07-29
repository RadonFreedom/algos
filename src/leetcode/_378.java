package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author xufeng
 * created at 2019.07.28 11:43
 */

public class _378 {
    public int kthSmallest(int[][] matrix, int k) {

        int rowLen = matrix.length;

        PriorityQueue<Cell> priorityQueue = new PriorityQueue<>(k, Comparator.comparing(cell -> cell.val));

        for (int i = 0; i < rowLen; i++) {
            priorityQueue.add(new Cell(0, i, matrix[0][i]));
        }

        //取出来k - 1个最小的，下一个就是第k个
        while (k > 1) {
            //把当前最小取出来
            Cell c = priorityQueue.poll();
            //刚取出来的是当前堆最小的
            k--;
            //把比他大一些的塞进去，要是本列到底没的加了，就等着下轮继续取最小
            if (c.row != rowLen - 1) {
                //这个操作能避免我们自己去比较斜元素，因为下一个最小的只可能是[c.row + 1][c.col]或者右侧元素
                priorityQueue.add(new Cell(c.row + 1, c.col, matrix[c.row + 1][c.col]));
            }
        }
        return priorityQueue.peek().val;
    }

    private class Cell {
        int row, col, val;

        public Cell(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
}
