package leetcode;

/**
 * @author xufeng
 * created at 2019.08.11 20:53
 */

public class _11 {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            res = Math.max(Math.min(height[i], height[j]) * (j - i), res);
            // 舍去当前两个中较短的
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
