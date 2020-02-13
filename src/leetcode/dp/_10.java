package leetcode.dp;

/**
 * @author Shaman
 * @date 2020/2/13 10:39
 */

public class _10 {

    // dp[i][j] = true -> s.substring(i) match p.substring(j)
    private Boolean[][] dp;

    public static void main(String[] args) {
        new _10().isMatch("mississippi", "mis*is*ip*.");
    }

    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1];
        return dp(0, 0, s, p);
    }

    private boolean dp(int i, int j, String s, String p) {
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (p.length() <= j) {
            return s.length() == i;
        }

        boolean res;
        // examine the first char of s & p
        boolean firstMatch = s.length() > i && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if (p.length() >= j + 2 && p.charAt(j + 1) == '*') {
            // 首先尝试不用'*'，再尝试用'*'
            res = dp(i, j + 2, s, p) || firstMatch && dp(i + 1, j, s, p);
        } else {
            res = firstMatch && dp(i + 1, j + 1, s, p);
        }
        dp[i][j] = res;
        return res;
    }
}
