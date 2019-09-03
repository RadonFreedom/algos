package leetcode;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author Radon Freedom
 * created at 2019.05.24 14:24
 */

public class _1_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            if (map.containsKey(remain)) {
                return new int[]{map.get(remain), i};
            }

            map.put(nums[i], i);
        }

        return new int[0];
    }
}
