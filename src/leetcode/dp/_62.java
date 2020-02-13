package leetcode.dp;

/**
 * @author xufeng
 * created at 2019.08.11 22:10
 */

public class _62 {
    public static int uniquePaths(int m, int n) {

        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            res[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                res[j] = res[j - 1] + res[j];
            }
        }
        return res[m - 1];
    }
}
