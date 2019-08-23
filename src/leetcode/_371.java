package leetcode;

/**
 * @author xufeng
 * created at 2019.08.21 17:43
 */

public class _371 {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
