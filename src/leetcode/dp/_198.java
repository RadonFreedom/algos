package leetcode.dp;

/**
 * @author Shaman
 * @date 2020/2/12 21:25
 */

public class _198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i+1] = Math.max(nums[i] + dp[i-1], dp[i]);
        }
        return dp[nums.length];
    }
}
