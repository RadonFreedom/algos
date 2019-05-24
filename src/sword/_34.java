package sword;

/**
 * 整数中1出现的次数（从1到n整数中1出现的次数）
 * https://www.nowcoder.com/practice/bd7f978302044eee894445e244c7eee6?tpId=13&tqId=11184&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.02.04 10:32
 */

public class _34 {
    public int NumberOf1Between1AndN_Solution(int n) {

        int result = 0;
        int remain;
        for (int i = 1; i <= n; i++) {
            remain = i;
            while (remain >= 1) {
                if (remain % 10 == 1) {
                    result++;
                }
                remain = remain / 10;
            }
        }
        return result;
    }
}
