package ali;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Radon Freedom
 * created at 2019.04.21 上午11:41
 */

public class _3 {

    public static void main(String[] args) {

    }

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
