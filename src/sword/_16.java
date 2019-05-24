package sword;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8?tpId=13&tqId=11164&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.01.27 18:20
 */

public class _16 {

    public int NumberOf1(int n) {

        int count = 0;
        int temp = 1;
        for (int i = 0; i < Integer.SIZE; i++) {

            if ((temp & n) != 0) {
                count ++;
            }
            temp = temp << 1;
        }
        return count;
    }
}
