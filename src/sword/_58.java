package sword;

/**
 * 机器人的运动范围
 * https://www.nowcoder.com/practice/6e5207314b5241fb83f2329e89fdecc8?tpId=13&tqId=11219&tPage=4&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.02.18 12:30
 */

public class _58 {

    private int threshold;
    private int rows;
    private int cols;
    private boolean[][] flag;

    public int movingCount(int threshold, int rows, int cols) {

        this.threshold = threshold;
        this.rows = rows;
        this.cols = cols;
        flag = new boolean[rows][cols];

        return findCnt(0, 0);
    }

    private int findCnt(int i, int j) {

        if (i < 0 || i >= rows || j < 0 || j >= cols || flag[i][j] || bitSum(i) + bitSum(j) > threshold) {
            return 0;
        }

        flag[i][j] = true;

        return findCnt(i + 1, j) +
                findCnt(i - 1, j) +
                findCnt(i, j + 1) +
                findCnt(i, j - 1) + 1;
    }

    private int bitSum(int a) {
        int sum = 0;
        while (a != 0) {
            sum += a % 10;
            a = a / 10;
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println(new _58().movingCount(5, 10, 10));
    }
}
