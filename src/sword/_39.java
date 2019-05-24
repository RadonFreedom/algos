package sword;

import java.util.ArrayList;

/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe?tpId=13&tqId=11194&tPage=3&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * 1. 15 / 5        商 3 余 0: 4, 5, 6
 * 2. 15 / (7+8)    商 1 余 0: 7, 8
 * 3. 24 / 8        商 3 余 0: 7, 8, 9
 * 4. 10 / (2+3)    商 2 余 0: 1, 2, 3, 4
 * @author Radon Freedom
 * created at 2019.02.08 16:38
 */

public class _39 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        //单独处理sum = 3时的情况
        if (sum == 3) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            result.add(list);
            return result;
        }

        //只能判断sum >= 5时的情况
        //无论sum是奇数还是偶数，序列中间数i <= sum / 2
        for (int i = 2; i <= sum / 2; i++) {
            //1. 序列长度n为奇数，序列中间数i为sum的可整除因子
            if (sum % i == 0) {
                int n = sum / i;
                //n为奇数 且 i 之前有足够多的数
                if (n % 2 == 1 && i > n / 2) {
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int j = i - n / 2; j <= i + n / 2; j++) {
                        list.add(j);
                    }
                    result.add(list);
                }
            }
            //2. 序列长度n为偶数，序列中间两个数之和(2 * i + 1)为sum的可整除因子
            if (sum % (2 * i + 1) == 0) {
                int n = 2 * sum / (2 * i + 1);
                // n为偶数 且 i 之前有足够多的数
                // 这里不用判断n为偶数，因为n = 2 * sum / (2 * i + 1)
                if (i >= n / 2) {
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int j = i - n / 2 + 1; j <= i + n / 2; j++) {
                        list.add(j);
                    }
                    result.add(list);
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {

        new _39().FindContinuousSequence(3);
    }
}
