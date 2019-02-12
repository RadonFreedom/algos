package sword;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 * https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.01.22 9:48
 */

public class _4 {

    public boolean Find(int target, int[][] array) {

        int colIndex = array.length - 1;
        int rowIndex = 0;


        while (colIndex != -1 && rowIndex != array[0].length) {

            if (target == array[colIndex][rowIndex]) {
                return true;
            } else if (target < array[colIndex][rowIndex]) {
                colIndex--;
            } else {
                rowIndex++;
            }
        }

        return false;
    }
}
