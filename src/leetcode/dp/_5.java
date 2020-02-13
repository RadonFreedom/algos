package leetcode.dp;

/**
 * @author Radon Freedom
 * created at 2019.05.27 17:49
 */

public class _5 {

    public static void main(String[] args) {
        new _5().longestPalindrome("babad");
    }

    private int maxLo = 0;
    private int maxHi = 0;

    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            getMaxLen(s, i, i);
            getMaxLen(s, i, i + 1);
        }

        return s.substring(maxLo, maxHi + 1);
    }

    private void getMaxLen(String s, int lo, int hi) {
        while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
            lo--;
            hi++;
        }
        if (hi - lo - 2 > maxHi - maxLo) {
            maxHi = hi - 1;
            maxLo = lo + 1;
        }
    }
}
