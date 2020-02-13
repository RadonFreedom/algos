package leetcode.dp;

import java.util.Arrays;

/**
 * @author Shaman
 * @date 2020/2/12 22:28
 */

public class _279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=0; i<=n; i++) {
            dp[i] = i;
            for(int j = (int) Math.sqrt(i); j > 0; j--) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        return dp[n];

    }
}
