package leetcode;

/**
 * @author xufeng
 * created at 2019.08.04 22:53
 */

public class _34 {

    public int[] searchRange(int[] nums, int target) {

        int[] res = new int[]{-1, -1};
        if (nums.length == 0) {
            return res;
        }

        int lo = 0, hi = nums.length - 1, mid;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        if (target == nums[lo]) {
            res[0] = lo;
        } else {
            return res;
        }

        hi = nums.length - 1;
        while (lo < hi) {
            mid = (lo + hi) / 2 + 1;
            if (nums[mid] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        if (target == nums[lo]) {
            res[1] = lo;
        }
        return res;
    }
}
