package sword;

/**
 * @author Radon Freedom
 * created at 2019.01.27 18:20
 */

public class _18 {

    public void reOrderArray(int[] array) {

        if (array == null || array.length == 0) {
            return;
        }

        //temp用来存放偶数，原数组array用来存放奇数
        int[] temp = new int[array.length];
        int tempIndex = 0, arrayIndex = 0;

        for (int i = 0; i < array.length; i++) {

            if (array[i] % 2 == 0) {
                temp[tempIndex++] = array[i];
            }
            else {
                array[arrayIndex++] = array[i];
            }
        }

        tempIndex = 0;
        while (arrayIndex < array.length) {
            array[arrayIndex++] = temp[tempIndex++];
        }
    }
}
