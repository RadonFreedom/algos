package leetcode;

/**
 * 需要借助数学推论：当 n >= m 时，i < m ⟹ j > 0 以及 i > 0 ⟹ j < n
 * 其中 j = (m + n + 1) / 2 - i
 *
 * @author Radon Freedom
 * created at 2019.05.24 15:27
 */

public class _4_MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null || (nums1.length == 0 && nums2.length == 0)) {
            return 0.0;
        }

        if (nums1.length > nums2.length) {
            int[] tmp = nums2;
            nums2 = nums1;
            nums1 = tmp;
        }
        int m = nums1.length;
        int n = nums2.length;

        int iMax = m;
        int iMin = 0;
        while (iMin <= iMax) {
            int i = (iMax + iMin) / 2;
            // m+n + 1的理由是当m+n为奇数，先算left值就能返回了
            // 当然也可以 j = (m + n) / 2 - i 然后先算right值并返回
            int j = (m + n + 1) / 2 - i;

            // i < m ⟹ j > 0
            if (i < m && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;
            }
            // i > 0 ⟹ j < n
            else if (i > 0 && nums1[i - 1] > nums2[j]) {
                iMax = i;
            } else {
                int left;
                if (i == 0) {
                    left = nums2[j - 1];
                } else if (j == 0) {
                    left = nums1[i - 1];
                } else {
                    left = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 != 0) {
                    return left;
                }
                int right;
                if (i == m) {
                    right = nums2[j];
                } else if (j == n) {
                    right = nums1[i];
                } else {
                    right = Math.min(nums1[i], nums2[j]);
                }
                return (left + right) / 2.0;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
    }
}
