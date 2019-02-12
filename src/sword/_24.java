package sword;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a?tpId=13&tqId=11172&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.01.30 10:17
 */

public class _24 {

    private ArrayList<Integer> retList;
    private int[][] matrix;

    public ArrayList<Integer> printMatrix(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {

            return new ArrayList<>(0);
        }

        this.matrix = matrix;
        retList = new ArrayList<>(matrix.length * matrix.length);

        printMatrix(0, matrix.length - 1, 0, matrix[0].length - 1);
        return retList;
    }

    private void printMatrix(int rowBegin, int rowEnd, int colBegin, int colEnd) {

        if (rowBegin > rowEnd || colBegin > colEnd) {
            return;
        }
        if (rowBegin == rowEnd && colBegin == colEnd) {
            retList.add(matrix[rowBegin][colBegin]);
            return;
        }

        for (int j = colBegin; j <= colEnd; j++) {
            retList.add(matrix[rowBegin][j]);
        }
        for (int i = rowBegin + 1; i <= rowEnd; i++) {
            retList.add(matrix[i][colEnd]);
        }
        if (rowBegin != rowEnd) {
            for (int j = colEnd - 1; j >= colBegin; j--) {
                retList.add(matrix[rowEnd][j]);
            }
        }
        if (colBegin != colEnd) {
            for (int i = rowEnd - 1; i > rowBegin; i--) {
                retList.add(matrix[i][colBegin]);
            }
        }
        printMatrix(rowBegin + 1, rowEnd - 1, colBegin + 1, colEnd - 1);
    }


    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1, 2}, {3, 4}};
        new _24().printMatrix(matrix);
    }
}
