package leetcode;

import java.util.PriorityQueue;

/**
 * @author xufeng
 * created at 2019.07.19 22:11
 */

public class _215 {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k + 1);

        /*
        求第K大个元素，需要保持堆中的元素是前K大个
        因此当堆大小为K+1时，必将有一个元素不是前K大，将此元素poll出堆
        按此遍历所有元素，堆顶元素即为第K大个
         */
        for (int num : nums) {
            priorityQueue.add(num);
            if (priorityQueue.size() == (k + 1)) {
                priorityQueue.poll();
            }
        }

        return priorityQueue.poll();
    }

    public static void main(String[] args) {
        new _215().findKthLargest(new int[]{3, 2, 1, 5, 4}, 2);
    }
}
