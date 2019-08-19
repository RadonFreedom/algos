package leetcode;

/**
 * @author xufeng
 * created at 2019.08.11 21:40
 */

public class _289 {

    public void gameOfLife(int[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int cnt = getNeighborLiveCnt(board, i, j);
                if ((cnt == 2 && board[i][j] == 1) || cnt == 3) {
                    board[i][j] += 2;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int getNeighborLiveCnt(int[][] board, int i, int j) {
        int cnt = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            if (k < 0 || k >= board.length) {
                continue;
            }
            for (int l = j - 1; l <= j + 1; l++) {
                if (l < 0 || l >= board[0].length || k == i && j == l) {
                    continue;
                }
                cnt += board[k][l] & 1;
            }
        }
        return cnt;
    }
}
