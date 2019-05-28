package leetcode;

/**
 * @author Radon Freedom
 * created at 2019.05.27 17:49
 */

public class _5 {

    private int maxBegin;
    private int maxEnd;

    public static void main(String[] args) {

        System.out.println(new _5().longestPalindrome("ccc"));
    }

    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }

        maxBegin = 0;
        maxEnd = 0;
        for (int i = 0; i < s.length(); i++) {
            getMaxLen(s, i, i);
            getMaxLen(s, i, i + 1);
        }

        return s.substring(maxBegin, maxEnd + 1);
    }

    private void getMaxLen(String s, int begin, int end) {

        if (end == s.length() || begin < 0 || s.charAt(begin) != s.charAt(end)) {
            if (end - begin - 2 > maxEnd - maxBegin) {
                maxBegin = begin + 1;
                maxEnd = end - 1;
            }
            return;
        }

        getMaxLen(s, begin - 1, end + 1);
    }
}
