package sword;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * https://www.nowcoder.com/practice/6f8c901d091949a5837e24bb82a731f2?tpId=13&tqId=11206&tPage=3&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.02.12 13:32
 */

public class _46 {

    public boolean isNumeric(char[] str) {

        if (str == null || str.length == 0) {
            return false;
        }

        //找到e或E的索引
        int eIndex = -1;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                if (eIndex != -1) {
                    return false;
                }
                else {
                    eIndex = i;
                }
            }
        }

        //如果没有找到e或E，说明必须是小数或整数（整数看作特殊的小数）
        if (eIndex == -1) {
            return isDecimal(str, 0, str.length - 1);
        }
        //如果str中含有e
        else {
            //如果找到的e或E的索引在首位或者末位，返回false
            if (eIndex == 0 || eIndex == str.length - 1) {
                return false;
            }
            else {
                //e之前的部分应该是小数
                if (!isDecimal(str, 0, eIndex - 1)) {
                    return false;
                }
                //e之后的部分应该是整数
                if (!isInteger(str, eIndex + 1, str.length - 1)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isInteger(char[] str, int beginIndex, int endIndex) {

        //如果有符号位，跳过符号位
        int overSignIndex = beginIndex;
        if (str[beginIndex] == '+' || str[beginIndex] == '-') {
            overSignIndex++;
        }
        //整数符号位之后的部分应该是数字1~9
        return isNumber1To9(str, overSignIndex, endIndex);
    }

    private boolean isDecimal(char[] str, int beginIndex, int endIndex) {

        //如果是整数，则返回true
        if (isInteger(str, beginIndex, endIndex)) {
            return true;
        }

        //到这里说明不是整数，找到小数点的索引
        int dotIndex = -1;
        for (int i = beginIndex; i <= endIndex; i++) {
            if (str[i] == '.') {
                if (dotIndex != -1) {
                    return false;
                }
                else {
                    dotIndex = i;
                }
            }
        }

        //没有找到小数点，或者小数点在beginIndex或endIndex，返回false
        if (dotIndex == -1 || dotIndex == beginIndex || dotIndex == endIndex) {
            return false;
        }

        //如果小数点前面的部分不是整数，返回false
        if (!isInteger(str, beginIndex, dotIndex - 1)) {
            return false;
        }

        //如果小数点后面的部分不是1~9的数字，返回false
        if (!isNumber1To9(str, dotIndex + 1, endIndex)) {
            return false;
        }

        return true;
    }

    private boolean isNumber1To9(char[] str, int beginIndex, int endIndex) {

        for (int i = beginIndex; i <= endIndex; i++) {
            if (!(str[i] <= '9' && str[i] >= '0')) {
                return false;
            }
        }
        return true;
    }
}
