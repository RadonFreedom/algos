package leetcode;

/**
 * @author xufeng
 * created at 2019.08.04 20:50
 */

public class _33 {
    public int search(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        int lo = 0, hi = nums.length - 1, mid;
        if (nums[lo] > nums[hi]) {
            while (lo < hi) {
                mid = (lo + hi) / 2;
                if (nums[hi] > nums[mid]) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }

            if (target < nums[0]) {
                hi = nums.length - 1;
            } else {
                lo = 0;
                hi--;
            }
        }

        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (target < nums[mid]) {
                hi = mid;
            } else if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return nums[lo] == target ? lo : -1;
    }
}
