package leetcode;

/**
 * @author Radon Freedom
 * created at 2019.05.29 15:37
 */

public class _42 {
    public int trap(int[] height) {

        int res = 0;
        int left, right;
        boolean hasLeft = false;
        for (int i = 0; i < height.length - 1; i++) {
            if (hasLeft) {
                if (height[i] <= height[i + 1]) {
                    continue;
                }

            }
        }

        return res;
    }
}
