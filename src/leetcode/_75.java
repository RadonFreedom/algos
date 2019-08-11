package leetcode;

/**
 * @author xufeng
 * created at 2019.08.11 16:52
 */

public class _75 {

    public void sortColors(int[] nums) {
        int zeroLow = 0;
        int twoHi = nums.length - 1;

        for (int i = 0; i <= twoHi; i++) {
            while (nums[i] == 2 && i < twoHi) {
                swap(nums, twoHi, i);
                twoHi--;
            }
            while (nums[i] == 0 && i > zeroLow) {
                swap(nums, zeroLow, i);
                zeroLow++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
