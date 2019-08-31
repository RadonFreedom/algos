package leetcode;

/**
 * @author xufeng
 * created at 2019.08.21 11:44
 */

public class _440 {
    public static void main(String[] args) {
        new _440().findKthNumber(10, 3);
    }

    /**
     *  - 如果k足够跨越下个数，curr++, k -= steps
     *  - k不够，进入下一层，curr *= 10, k--
     *  - k == 0 结束
     */
    public int findKthNumber(int n, int k) {
        // 数字1永远是第一个数字
        int curr = 1;
        k--;
        while (k != 0) {
            int nextSteps = calNextSteps(curr, curr + 1, n);
            if (k >= nextSteps) {
                curr++;
                k -= nextSteps;
            } else {
                curr *= 10;
                k--;
            }
        }

        return curr;
    }

    /**
     * 计算跨越步数
     *  - 如果本层残缺，next > n+1，rst += n+1-curr
     *  - 如果本层饱满，next <= n+1，rst += next-curr
     *
     *  long 避免了 n = 10e9 时，curr，next 溢出
     */
    private int calNextSteps(long curr, long next, int n) {
        int rst = 0;

        while (curr <= n) {
            rst += Math.min(next, n + 1) - curr;
            curr *= 10;
            next *= 10;
        }

        return rst;
    }
}
