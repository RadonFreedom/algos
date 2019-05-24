package sword;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=13&tqId=11181&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.02.03 13:06
 */

public class _32 {

    public int MoreThanHalfNum_Solution(int[] array) {

        Map<Integer, Integer> map = new HashMap<>(array.length);
        Integer temp;

        for (int i = 0; i < array.length; i++) {
            temp = map.get(array[i]);
            if (temp == null) {
                temp = 0;
            }
            map.put(array[i], temp + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > array.length / 2) {
                return entry.getKey();
            }
        }

        return 0;
    }
}
