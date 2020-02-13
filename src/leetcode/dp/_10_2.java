package leetcode.dp;

/**
 * @author Shaman
 * @date 2020/2/13 11:25
 */

public class _10_2 {

    public boolean isMatch(String s, String p) {
        // dp[i][j] = true -> s.substring(i) match p.substring(j)
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        // s = "" && p = ""
        dp[s.length()][p.length()] = true;

        // s从""开始
        for (int i = s.length(); i >= 0; i--) {
            // p从最后一个字符开始, 因为s,p都为""已经讨论过
            for (int j = p.length() - 1; j >= 0; j--) {

                boolean firstMatch = s.length() > i && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

                if (p.length() >= j + 2 && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || firstMatch && dp[i + 1][j];
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}
