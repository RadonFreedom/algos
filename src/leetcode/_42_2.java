package leetcode;

/**
 * @author xufeng
 * created at 2019.07.14 23:35
 */

public class _42_2 {

    /**
     * 当前索引左侧和右侧最高值的较小值决定了本位的水量
     */
    public int trap(int[] height) {

        int res = 0;
        int left = 0, right = height.length - 1;
        int lm = 0, rm = 0;
        while (left <= right) {
            //计算left索引左侧的最高值
            lm = Math.max(lm, height[left]);
            //计算right索引右侧的最高值
            rm = Math.max(rm, height[right]);
            if (lm < rm) {
                /*
                尽管rm不一定是left的右侧最大值
                但lm是left的左侧最大值
                lm < rm说明lm是left的左右侧最高值的较小值
                因此left的水高可以计算出来
                 */
                res += lm - height[left];
                left++;
            } else {
                res += rm - height[right];
                right--;
            }
        }

        return res;
    }
}
