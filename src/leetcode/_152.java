package leetcode;

/**
 * @author xufeng
 * created at 2019.07.29 15:07
 */

public class _152 {
    public int maxProduct(int[] nums) {

        int res = nums[0];
        int max = res;
        int min = res;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = min;
                min = max;
                max = tmp;
            }
            // 连续的数组必会在某个地方中断
            // 只需要比较连续相乘得到的值和当前索引对应的值就能得到是否需要在这里中断
            min = Math.min(min * nums[i], nums[i]);
            max = Math.max(max * nums[i], nums[i]);

            //max中的值不知道后面自己会不会变成最小的，所以res作为全局结果来输出
            res = Math.max(max, res);
        }
        return res;
    }

    public static void main(String[] args) {
        new _152().maxProduct(new int[]{2,3,-2,4});
    }
}
