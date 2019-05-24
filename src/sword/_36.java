package sword;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * https://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b?tpId=13&tqId=11186&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.02.05 9:58
 */

public class _36 {
    public int GetUglyNumber_Solution(int index) {

        if (index == 0) {
            return 0;
        }

        Integer[] uglys = new Integer[index];

        uglys[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;

        for (int i = 1; i < index; i++) {
            uglys[i] = Math.min(uglys[p2] * 2, Math.min(uglys[p3] * 3, uglys[p5] * 5));
            //找到数组使用哪个（一个或多个）索引相乘给丑数数组带来下一个最小的丑数
            //都使用if而不是if-else避免了出现相同丑数只递增一个索引的情况
            if (uglys[i] == uglys[p2] * 2) {
                p2++;
            }
            if (uglys[i] == uglys[p3] * 3) {
                p3++;
            }
            if (uglys[i] == uglys[p5] * 5) {
                p5++;
            }
        }

        return uglys[index - 1];
    }

    public static void main(String[] args) {
        new _36().GetUglyNumber_Solution(8);
    }
}
