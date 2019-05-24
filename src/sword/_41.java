package sword;

/**
 *
 * 将一个字符串转换成一个整数。数值为0或者字符串不是一个合法的数值则返回0。
 * https://www.nowcoder.com/practice/1277c681251b4372bdef344468e4f26e?tpId=13&tqId=11202&tPage=3&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.02.10 13:06
 */

public class _41 {

    public int StrToInt(String str) {

        if (str == null || str.length() == 0) {
            return 0;
        }

        char[] chars = str.toCharArray();
        char c = chars[0];

        int sign = 1;
        int result = 0;
        if (c == '+') {
            sign = 1;
        }
        else if (c == '-') {
            sign = -1;
        }
        else if (c <= '9' && c >= '0') {
            result = c - 48;
        }
        else {
            return 0;
        }

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] <= '9' && chars[i] >= '0') {
                result = result * 10 + chars[i] - 48;
            }
            else {
                return 0;
            }
        }

        return sign * result;
    }
}
