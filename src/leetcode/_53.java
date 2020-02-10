package leetcode;

/**
 * 贪心
 *
 * @author Shaman
 * @date 2020/2/10 14:27
 */

public class _53 {
    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 当前子数组和
        int curArraySum = nums[0];
        int res = curArraySum;
        for (int i = 1; i < nums.length; i++) {
            // 当前子数组和取贪婪值
            curArraySum = Math.max(curArraySum + nums[i], nums[i]);
            res = Math.max(res, curArraySum);
        }

        return res;
    }
}
