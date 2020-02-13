package leetcode.backtracking;

/**
 * @author Shaman
 * @date 2020/2/13 11:25
 */

public class _10 {
    public boolean isMatch(String s, String p) {
        // p.len = 0
        if (p.length() == 0) {
            return s.length() == 0;
        }

        // examine the first char of s & p
        boolean firstMatch = s.length() >= 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*') {
            // 有'*'存在，首先尝试不用'*'，再尝试用'*'
            return isMatch(s, p.substring(2)) || firstMatch && isMatch(s.substring(1), p);
        } else {
            // 无'*'，scrub the first char of s & p
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}
