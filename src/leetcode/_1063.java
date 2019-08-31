package leetcode;

import java.util.LinkedList;

/**
 * @author xufeng
 * created at 2019.08.19 17:35
 */

public class _1063 {
    public int validSubarrays(int[] nums) {
        int rst = 0;
        // 维护一个递增的栈，将每次递减时的结果累加进rst
        // 当nums中出现递减，在当前索引取子数组的end(exclusive)，在栈顶取子数组的begin(inclusive)
        LinkedList<Integer> s = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            while (!s.isEmpty() && nums[s.peek()] > nums[i]) {
                rst += i - s.pop();
            }
            s.push(i);
        }

        while (!s.isEmpty()) {
            rst += nums.length - s.pop();
        }
        return rst;
    }
}
