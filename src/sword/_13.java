package sword;

/**
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=13&tqId=11161&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.01.26 12:25
 */

public class _13 {

    public int JumpFloor(int target) {

        if (target <= 0) {
            return 0;
        }

        return differentWaysCount(target);
    }

    private int differentWaysCount(int target) {

        if (target <= 1) {
            return 1;
        }

        return differentWaysCount(target - 1) + differentWaysCount(target - 2);
    }
}
