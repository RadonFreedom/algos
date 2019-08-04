package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xufeng
 * created at 2019.08.01 19:50
 */

public class _54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new LinkedList<>();
        }
        int iBegin = 0;
        int jBegin = 0;
        int iEnd = matrix.length - 1;
        int jEnd = matrix[0].length - 1;
        LinkedList<Integer> res = new LinkedList<>();
        while (jBegin<= jEnd && iBegin <= iEnd) {
            for (int j = jBegin; j <= jEnd; j++) {
                res.add(matrix[iBegin][j]);
            }
            jBegin--;
            for (int i = 0; i <= iEnd; i++) {
                res.add(matrix[i][jEnd]);
            }
            iEnd--;
            for (int j = jEnd; j < ; j++) {

            }
        }

        return res;
    }
}
