package sword;

import java.util.HashMap;
import java.util.Map;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 请找出数组中任意一个重复的数字。
 * https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=13&tqId=11181&tPage=2&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.02.10 13:24
 */

public class _42 {

    public boolean duplicate(int numbers[], int length, int[] duplication) {

        if (numbers == null || numbers.length == 0 || duplication == null || duplication.length != 1) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>(numbers.length);
        for (int i : numbers) {
            if (map.containsKey(i)) {
                int n = map.get(i);
                if (n >= 1) {
                    duplication[0] = i;
                    return true;
                }
                map.put(i, n + 1);
            }
            else {
                map.put(i, 1);
            }

        }
        return false;
    }
}
