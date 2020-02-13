package leetcode.dp;

/**
 * @author Shaman
 * @date 2020/2/13 13:47
 */

public class _44 {


    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;

        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                if (p.charAt(j) == '*') {
                    dp[i][j] = s.length() > i && dp[i+1][j] || dp[i][j+1];
                } else {
                    dp[i][j] = s.length() > i && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
                            && dp[i+1][j+1];
                }
            }
        }

        return dp[0][0];
    }
}
