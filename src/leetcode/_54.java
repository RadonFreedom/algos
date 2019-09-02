package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Shaman
 * @date 2019/9/2 17:16
 */

public class _54 {
    /**
     * (rowLo, colLo) -> (rowLo, colHi)
     *       /\                   |
     *       |                   \/
     * (rowHi, colLo) <- (rowHi, colHi)
     */
    public static List<Integer> spiralOrder(int[][] matrix) {

        LinkedList<Integer> rst = new LinkedList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return rst;
        }

        int colLo = 0;
        int colHi = matrix[0].length - 1;
        int rowHi = matrix.length - 1;
        int rowLo = 0;

        while (rowLo <= rowHi && colLo <= colHi) {
            for (int j = colLo; j <= colHi; j++) {
                rst.add(matrix[rowLo][j]);
            }
            rowLo++;

            for (int i = rowLo; i <= rowHi; i++) {
                rst.add(matrix[i][colHi]);
            }
            colHi--;

            // 判断rowHi是否存在
            if (rowLo <= rowHi) {
                for (int j = colHi; j >= colLo; j--) {
                    rst.add(matrix[rowHi][j]);
                }
            }
            rowHi--;

            // 判断colLo是否存在
            if (colLo <= colHi) {
                for (int i = rowHi; i >= rowLo; i--) {
                    rst.add(matrix[i][colLo]);
                }
            }
            colLo++;
        }

        return rst;
    }
}
