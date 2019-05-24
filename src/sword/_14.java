package sword;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=11162&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.01.26 13:06
 */

public class _14 {

    public int JumpFloorII(int target) {


        if (target <= 0) {
            return 0;
        }

        return differentWaysCount(target);
    }

    private int differentWaysCount(int target) {

        if (target <= 1) {
            return 1;
        }

        int differentWays = 0;
        for (int i = 1; i <= target; i++) {
            differentWays = differentWays + differentWaysCount(target - i);
        }
        return differentWays;
    }
}
