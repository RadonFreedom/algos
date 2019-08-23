package leetcode;

/**
 * @author xufeng
 * created at 2019.08.21 11:44
 */

public class _440 {
    public static void main(String[] args) {
        new _440().findKthNumber(10, 3);
    }
    public int findKthNumber(int n, int k) {
        // 树的层数
        int maxHei = String.valueOf(n).length();

        //当前数字
        int curr = 1;
        k--;

        while (k != 0) {
            int nextSteps = calNextSteps(curr, curr + 1, n);
            // 如果k可以直接越过这个数
            if (k >= nextSteps) {
                k -= nextSteps;
                curr++;
            } else {
                k--;
                curr *= 10;
            }
        }
        return curr;
    }

    private int calNextSteps(long curr, long next, int n) {
        int res = 0;
        // 迭代到树的底层
        while (curr <= n) {
            // 如果本层饱满，n+1 >= next，next - curr是本层个数
            // 本层残缺，n+1 < next，n - curr就是残缺的底层个数
            res += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return res;
    }
}
