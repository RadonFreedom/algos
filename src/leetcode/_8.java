package leetcode;

/**
 * @author Radon Freedom
 * created at 2019.05.28 17:02
 */

public class _8 {

    public int myAtoi(String str) {

        int result = 0;

        if (str == null || str.length() == 0) {
            return 0;
        }

        //去掉空格
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        char[] chars = str.substring(i).toCharArray();

        if (chars.length == 0) {
            return 0;
        }

        boolean neg = false;
        i = 0;
        if (chars[0] == '+' || chars[0] == '-') {

            if (chars[0] == '-') {
                neg = true;
            }
            i++;
        }

        while (i < chars.length && chars[i] <= '9' && chars[i] >= '0') {
            int x = chars[i] - '0';
            if (integerOverflow(result, x, neg)) {
                if (neg) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            result = result * 10;
            result += x;
            i++;
        }

        return neg ? -result : result;
    }

    private boolean integerOverflow(int result, int x, boolean neg) {
        if (!neg) {
            return result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && x > Integer.MAX_VALUE % 10;
        } else {
            return result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && x > Integer.MAX_VALUE % 10 + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new _8().myAtoi("+1"));
    }
}
