package leetcode;

import java.util.HashSet;

/**
 * @author xufeng
 * created at 2019.07.29 10:31
 */

public class _128 {

    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int rst = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (Integer num : nums) {
            if (!set.contains(num - 1)) {
                int cnt = 0;
                while (set.contains(num)) {
                    cnt++;
                    num++;
                    set.remove(num);
                }
                rst = Math.max(rst, cnt);
            }
        }

        return rst;
    }
}
