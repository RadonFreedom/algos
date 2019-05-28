package leetcode;

/**
 * @author Radon Freedom
 * created at 2019.05.24 15:27
 */

public class _4_MedianOfTwoSortedArrays {

    private int[] nums1, nums2;
    /**
     * 是否是两个数的平均值为中位数
     */
    private boolean isTwoMid;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null || (nums1.length == 0 && nums2.length == 0)) {
            return 0.0;
        }

        int i1 = 0, j1 = nums1.length - 1;
        int i2 = 0, j2 = nums2.length - 1;
        this.nums1 = nums1;
        this.nums2 = nums2;
        if ((nums1.length + nums2.length) % 2 == 0) {
            isTwoMid = true;
        } else {
            isTwoMid = false;
        }

        return findMid(i1, j1, i2, j2);
    }

    private double findMid(int i1, int j1, int i2, int j2) {

        return 0;
    }
}
