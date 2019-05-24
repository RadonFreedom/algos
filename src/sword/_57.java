package sword;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * https://www.nowcoder.com/questionTerminal/c61c6999eecb4b8f88a98f66b273a3cc
 *
 * @author Radon Freedom
 * created at 2019.02.17 12:49
 */

public class _57 {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int[] flag = new int[matrix.length];
        //试着从每个位置作为起始位置查找路径，直到返回true
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(matrix, rows, cols, i, j, str, 0, flag)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
        //计算出i行j列对应在数组中的索引
        int index = i * cols + j;
        //首先：i, j不能在矩阵中越界
        //其次：矩阵该位置的字符matrix[index] == str[k]
        //再次：不能走回头路，flag[index] == 0
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1) {
            return false;
        }
        if (k == str.length - 1) {
            return true;
        }
        //走到这里说明matrix[index] == str[k]，可以进行下一个字符str[k+1]的搜索（方向为上下左右）
        //只要有一个方向可以成功，就返回true
        //把这个位置的flag标记为1，表明不能走回头路，只能走flag标记不是1的路径
        flag[index] = 1;
        if (helper(matrix, rows, cols, i - 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i + 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j - 1, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j + 1, str, k + 1, flag)) {
            return true;
        }
        flag[index] = 0;
        return false;
    }

    public static void main(String[] args) {

        char[] matrix = "abcesfcsadee".toCharArray();
        new _57().hasPath(matrix, 3, 4, "bcced".toCharArray());
    }
}

