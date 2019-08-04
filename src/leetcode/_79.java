package leetcode;

/**
 * @author xufeng
 * created at 2019.08.04 19:49
 */

public class _79 {
    public boolean exist(char[][] board, String word) {
        boolean[][] flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (searchHere(i, j, 0, board, word, flag)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean searchHere(int i, int j, int index, char[][] board, String word, boolean[][] flag) {
        if (index >= word.length()) {
            return true;
        }

        if (i >= board.length || i < 0 || j >= board[0].length || j < 0
                || flag[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        index++;
        flag[i][j] = true;
        if (searchHere(i + 1, j, index, board, word, flag)
                || searchHere(i, j + 1, index, board, word, flag)
                || searchHere(i - 1, j , index, board, word, flag)
                || searchHere(i, j - 1, index, board, word, flag)) {
            return true;
        }

        flag[i][j] = false;
        return false;
    }
}
