package sword;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * https://www.nowcoder.com/questionTerminal/390da4f7a00f44bea7c2f3d19491311b
 *
 * @author Radon Freedom
 * created at 2019.01.23 8:50
 */

public class _7 {

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length < 2 || array[0] > sum) {
            return result;
        }
        int i = 0;
        int j = array.length - 1;

        while (i < j) {
            if (sum == array[i] + array[j]) {

                result.add(array[i]);
                result.add(array[j]);
                return result;
            }
            else if (sum > array[i] + array[j]) {
                i++;
            }
            else {
                j--;
            }
        }
        return result;
    }
}
