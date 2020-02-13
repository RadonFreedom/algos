package leetcode.dp;

/**
 * @author Shaman
 * @date 2020/2/13 14:56
 */

public class _44_2 {
    Boolean[][] dp;
    String s;
    String p;

    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1];
        this.s = s;
        this.p = p;
        return match(0, 0);
    }

    private boolean match(int i, int j) {
        if (p.length() == j) {
            return s.length() == i;
        }
        if (s.length() < i) {
            return false;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        boolean isMatch;
        if (p.charAt(j) == '*') {
            isMatch = match(i + 1, j) || match(i, j + 1);
        } else {
            isMatch = s.length() > i && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
                    && match(i + 1, j + 1);
        }

        dp[i][j] = isMatch;
        return isMatch;
    }
}
