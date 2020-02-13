package leetcode.dp;

/**
 * @author Shaman
 * @date 2020/2/13 10:33
 */

public class _322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
            for (int coin : coins) {
                if (i == coin) {
                    dp[i] = 1;
                } else if (i > coin && dp[i - coin] > 0) {
                    if (dp[i] == -1) {
                        dp[i] = 1 + dp[i - coin];
                    } else {
                        dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                    }
                }
            }
        }
        return dp[amount];
    }
}
