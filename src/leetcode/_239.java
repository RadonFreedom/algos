package leetcode;

import java.util.LinkedList;

/**
 * @author xufeng
 * created at 2019.07.26 18:12
 */

public class _239 {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k == 1) {
            return nums;
        }

        LinkedList<Integer> l = new LinkedList<>();
        int[] rst = new int[nums.length - k + 1];
        int rstIdx = 0;

        for (int i = 0; i < nums.length; i++) {

            while (!l.isEmpty() && i >= l.getFirst() + k) {
                l.removeFirst();
            }

            while (!l.isEmpty() && nums[i] >= nums[l.getLast()]) {
                l.removeLast();
            }
            l.addLast(i);

            if (i >= k - 1) {
                rst[rstIdx] = nums[l.getFirst()];
                rstIdx++;
            }
        }
        return rst;
    }
}
