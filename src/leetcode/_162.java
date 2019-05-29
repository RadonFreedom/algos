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

        int left = 0, right = nums.length - 1, mid = (right - left) / 2 + left;
        while (true) {
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid] > nums[mid - 1]) {
                left = mid;
            } else {
                right = mid;
            }
            mid = (right - left) / 2 + left;
        }
    }
}
