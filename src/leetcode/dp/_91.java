package leetcode.dp;

/**
 * @author Shaman
 * @date 2020/2/10 18:57
 */

public class _91 {
    public static int numDecodings(String s) {
        int[] res = new int[s.length() + 1];
        res[s.length()] = 1;
        res[s.length() - 1] = s.endsWith("0") ? 0 : 1;
        for (int i = s.length() - 2; i >= 0; i--) {
            int val = Integer.valueOf(s.substring(i, i + 2));
            if (val > 26) {
                res[i] = res[i + 1];
            } else if (val >= 10) {
                res[i] = res[i + 1] + res[i + 2];
            } else {
                res[i] = 0;
            }
        }
        return res[0];
    }
}
