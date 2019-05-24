package sword;

/**我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&tqId=11163&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.01.27 18:20
 */

public class _15 {

    public int RectCover(int target) {

        if (target <= 0) {
            return 0;
        }
        else if (target == 1) {
            return 1;
        }

        return differentWaysOfRectCover(target - 1) + differentWaysOfRectCover(target - 2);
    }

    private int differentWaysOfRectCover(int target) {

        if (target <= 1) {
            return 1;
        }

        return differentWaysOfRectCover(target - 1) + differentWaysOfRectCover(target - 2);
    }
}
