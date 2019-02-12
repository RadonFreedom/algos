package sword;

/**
 *大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 *
 * https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&tqId=11160&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.01.25 11:03
 */

public class _12 {

    /**
     *
     * @param n <= 39
     * @return 斐波那契数列的第n项
     */
    public int Fibonacci(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int a = 0, b = 1;
        int temp;

        for (int i = 2; i <= n; i++) {
            temp = b;
            b = a + b;
            a = temp;
        }
        return b;
    }
}
