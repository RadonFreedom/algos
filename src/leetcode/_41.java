package leetcode;

/**
 * @author xufeng
 * created at 2019.07.29 09:49
 */

public class _41 {
    public int firstMissingPositive(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            //判断是否有办法交换num[i]和num[num[i]-1]，有办法就一直交换到不满足条件为止
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                //交换和索引不对应的元素到对应索引位置
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        //如果数组中元素都在对应位置
        return nums.length + 1;
    }
}
