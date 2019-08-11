package leetcode;

/**
 * @author Radon Freedom
 * created at 2019.05.28 11:40
 */

public class _162 {

    public int findPeakElement(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        if (nums[0] > nums[1]) return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;

        int lo = 0, hi = nums.length - 1, mid;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (nums[mid] > nums[mid + 1]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
