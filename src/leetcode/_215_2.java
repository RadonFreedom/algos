package leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * @author xufeng
 * created at 2019.07.20 14:31
 */

public class _215_2 {

    public static void main(String[] args) {
        int[] nums = new int[3];
        for (int i = 0; i < 3; i++) {
            nums[i] = i;
        }
        while (true) {
            new _215_2().findKthLargest(new int[]{7, 6, 5, 4, 3, 2, 1}, 2);
        }
    }

    /**
     * doing this with quick select (quick sort only one side of the array).
     */
    public int findKthLargest(int[] nums, int k) {

        if (nums.length == 1) {
            return nums[0];
        }

        //取k为第k小个
        k = nums.length - k;
        shuffle(nums);
        return partition(0, nums.length - 1, k, nums);

    }

    private int partition(int lo, int hi, int k, int[] nums) {
        //避免处理了3个元素的情况，太扯淡了
        if (lo >= hi - 3) {
            Arrays.sort(nums, lo, hi + 1);
            return nums[k];
        }

        int i = lo + 1;
        int j = hi;

        while (true) {
            while (i < j && nums[j] >= nums[lo]) j--;
            while (i < j && nums[i] <= nums[lo]) i++;
            if (i == j) {
                break;
            } else {
                swap(nums, i, j);
            }
        }

        if (nums[i] < nums[lo]) {
            swap(nums, i, lo);
            if (i > k) {
                hi = i - 1;
            } else {
                lo = i + 1;
            }
        } else {
            if (i > k) {
                hi = i - 1;
            } else {
                lo = i;
            }
        }

        return partition(lo, hi, k, nums);
    }

    private void shuffle(int[] nums) {

        Random random = new Random();
        for (int i = 1; i < nums.length; i++) {
            int r = random.nextInt(i + 1);
            swap(nums, i, r);
        }
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
