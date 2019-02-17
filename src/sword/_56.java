package sword;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788?tpId=13&tqId=11217&tPage=4&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.02.17 11:08
 */

public class _56 {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        if (num == null || num.length < size || size < 1) {
            return new ArrayList<>();
        }

        int temp;
        Integer[] ret = new Integer[num.length - size + 1];
        for (int i = 0; i < num.length - size + 1; i++) {
            temp = num[i];
            for (int j = 1; j < size; j++) {
                if (temp < num[i + j]) {
                    temp = num[i + j];
                }
            }
            ret[i] = temp;
        }
        return new ArrayList<>(Arrays.asList(ret));
    }
}
