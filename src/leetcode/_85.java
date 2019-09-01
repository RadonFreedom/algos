package leetcode;

/**
 * @author Shaman
 * @date 2019/8/31 18:21
 */

public class _85 {

    public static void main(String[] args) {
        maximalRectangle(new char[][]{{'1','1'}});
    }
    /**
     * DP:
     * - 迭代方式选择为一排一排扫描，每排扫描完后扫描下一排
     * - heights 存储当前列当前的连续高度
     * - left 存储当前位置的左侧边界，由本行本位置左侧的连续1个数和上一行本位置左侧的连续1个数共同决定
     * - right 存储当前位置的右侧边界，由本行本位置右侧的连续1个数和上一行本位置右侧的连续1个数共同决定
     *
     * 在计算 left 和 right 时，如果上一行对应元素为0，不应该影响下一行的左右边界，因此置不影响值
     */
    public static int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;

        int rst = 0;
        int[] heights = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        // 不影响第一行的右边界
        for (int i = 0; i < n; i++) {
            right[i] = n - 1;
        }

        for (int i = 0; i < m; i++) {
            // 更新height
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            int currRowLeft = 0;
            // 从左到右 更新left
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    // 取决于本行的当前left边界和上一行的left边界
                    left[j] = Math.max(currRowLeft, left[j]);
                } else {
                    // 当前元素是0，本行的当前left边界右移
                    currRowLeft = j + 1;
                    // 不影响下一行对应位置的左边界
                    left[j] = 0;
                }
            }

            int currRowRight = n - 1;
            // 从右到左 更新right
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(currRowRight, right[j]);
                } else {
                    // 当前元素是0，本行的当前right边界左移
                    currRowRight = j - 1;
                    // 不影响下一行对应位置的右边界
                    right[j] = n - 1;
                }
            }

            // 更新 rst
            for (int j = 0; j < n; j++) {
                rst = Math.max(rst, (right[j] - left[j] + 1) * heights[j]);
            }
        }

        return rst;
    }
}
