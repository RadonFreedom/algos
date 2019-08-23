package leetcode;

import java.util.LinkedList;

/**
 * @author xufeng
 * created at 2019.08.19 17:35
 */

public class _1063 {
    public int validSubarrays(int[] nums) {
        int rst = 0;
        LinkedList<Integer> l = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            while (!l.isEmpty() && nums[l.getLast()] > nums[i]) {
                rst += i - l.removeLast();
            }
            l.add(i);
        }

        while (!l.isEmpty()) {
            rst += nums.length - l.pop();
        }
        return rst;
    }
}
