package leetcode;

/**
 * @author xufeng
 * created at 2019.08.04 20:12
 */

public class _55 {
    public boolean canJump(int[] nums) {

        int i = 0;
        int maxIdx = 0;
        while (i < nums.length && i <= maxIdx) {
            if (i + nums[i] >= nums.length - 1) {
                return true;
            }
            maxIdx = Math.max(i + nums[i], maxIdx);
            i++;
        }
        return false;
    }
}
