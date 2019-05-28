package leetcode;

/**
 * @author Radon Freedom
 * created at 2019.05.28 10:25
 */

public class _7 {

    public int reverse(int x) {
        int result = 0;
        result += (x % 10);
        boolean fushu = x < 0;
        while (x >= 10 || x <= -10) {
            x = x / 10;
            if (overflow(x, result, fushu)) {
                return 0;
            }
            result = result * 10;
            result += (x % 10);
        }
        return result;
    }

    private boolean overflow(int x, int result, boolean fushu) {
        if (!fushu) {
            return result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && x % 10 > Integer.MAX_VALUE % 10;
        } else {
            return result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE / 10 && x % 10 < Integer.MIN_VALUE % 10;
        }
    }
}















