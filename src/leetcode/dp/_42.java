package leetcode.dp;

/**
 * @author Shaman
 * @date 2020/2/17 15:42
 */

public class _42 {
    public int trap(int[] height) {
        if(height == null || height.length <= 2) {
            return 0;
        }
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length-1] = height[height.length-1];

        for(int i = 1; i<height.length; i++) {
            leftMax[i]=Math.max(leftMax[i-1], height[i]);
        }
        for(int i = height.length - 2; i>=0; i--) {
            rightMax[i]=Math.max(rightMax[i+1], height[i]);
        }

        int res = 0;
        for(int i = 1; i<height.length; i++) {
            // 观察可得：储水量[i] = Math.min(rightMax[i] - height[i], leftMax[i] - height[i]);
            res += Math.min(rightMax[i], leftMax[i]) - height[i];
        }
        return res;
    }
}
