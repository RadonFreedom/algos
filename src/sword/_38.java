package sword;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * https://www.nowcoder.com/practice/96bd6684e04a44eb80e6a68efc0ec6c5?tpId=13&tqId=11188&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.02.06 18:27
 */

public class _38 {

    private int[] array;
    private int[] tempArray;
    private int count = 0;

    public int InversePairs(int [] array) {

        if (array == null || array.length == 0) {
            return 0;
        }

        this.array = array;
        tempArray = new int[array.length];
        merge(0, array.length - 1);
        return count;
    }

    private void merge(int lo, int hi) {

        if (hi <= lo + 1) {
            if (array[lo] > array[hi]) {
                int tempInt = array[lo];
                array[lo] = array[hi];
                array[hi] = tempInt;
                count++;
            }
            return;
        }

        int mid = lo + (hi - lo) / 2;
        merge(lo, mid);
        merge(mid + 1, hi);

        if (array[mid] < array[mid + 1]) {
            return;
        }

        //左子数组索引
        int i = lo;
        //右子数组索引
        int j = mid + 1;
        //tempArray索引
        int k = lo;
        while (i <= mid && j <= hi) {
            if (array[i] <= array[j]){
                tempArray[k] = array[i];
                i++;
            }
            else {
                tempArray[k] = array[j];
                //array[j] < array[i~mid]，构成了mid + 1 - i个逆序对
                count += (mid + 1 - i);
                count = count % 1000000007;
                j++;
            }
            k++;
        }

        while (i <= mid) {
            tempArray[k] = array[i];
            i++;
            k++;
        }
        while (j <= hi) {
            tempArray[k] = array[j];
            j++;
            k++;
        }

        copy(lo, hi);
    }

    private void copy(int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            array[i] = tempArray[i];
        }
    }
}

