package leetcode.dp;

/**
 * @author Shaman
 * @date 2020/2/10 16:52
 */

public class _70 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        //DP
        int a = 1;
        int b = 1;
        int res = 2;
        for (int i = 2; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}
