package sword;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * <p>
 * https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.01.25 11:03
 */

public class _11 {

    public int minNumberInRotateArray(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }

        //数组没有旋转
        if (array[0] < array[array.length - 1]) {
            return array[0];
        }

        int left = 0;
        int right = array.length - 1;
        int mid = left + (right - left + 1) / 2;

        while (true) {

            if (array[mid] >= array[left]) {
                left = mid;
            } else if (array[mid] <= array[right]) {
                right = mid;
            }

            mid = left + (right - left + 1) / 2;

            if (right - left == 1) {
                return array[right] > array[left] ? array[left] : array[right];
            }
        }
    }
}
