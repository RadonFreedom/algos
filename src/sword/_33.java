package sword;

/**
 * 最大连续子序列的和
 * https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=13&tqId=11183&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.02.04 9:59
 */

public class _33 {

    public int FindGreatestSumOfSubArray(int[] array) {

        int result = Integer.MIN_VALUE;
        int sum;

        if (array == null || array.length == 0) {
            return result;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j + i < array.length; j++) {
                sum = 0;
                for (int k = j; k <= j + i; k++) {
                    sum = sum + array[k];
                }
                if (sum > result) {
                    result = sum;
                }
            }
        }

        return result;
    }
}
