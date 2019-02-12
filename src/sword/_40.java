package sword;

/**
 *
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * https://www.nowcoder.com/practice/59ac416b4b944300b617d4f7f111b215?tpId=13&tqId=11201&tPage=3&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.02.10 12:10
 */

public class _40 {

    public int Add(int num1,int num2) {

        int carry = 0;
        int result = 0;
        int bitIndex = 1;
        for (int i = 1; i < Integer.SIZE; i++) {
            result = result ^ (bitIndex & num1) ^ (bitIndex & num2) ^ carry;
            carry = ((carry & num1) | (carry & num2) | ((bitIndex & num1) & (bitIndex & num2))) << 1;
            bitIndex = bitIndex << 1;
        }
        result = result ^ (bitIndex & num1) ^ (bitIndex & num2) ^ carry;
        return result;
    }
}
