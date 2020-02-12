package leetcode;

/**
 * @author xufeng
 * created at 2019.07.29 15:07
 */

public class _152 {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int min = res;
        int max = res;
        for(int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int a = max * num;
            int b = min * num;
            min = Math.min(Math.min(a, b), num);
            max = Math.max(Math.max(a, b), num);
            res = Math.max(res, max);
        }
        return res;
    }
}
