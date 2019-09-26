package leetcode;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author Shaman
 * @date 2019/8/27 13:21
 */

public class _773 {

    public static int slidingPuzzle(int[][] board) {

        String ans = "123450";
        HashSet<String> marked = new HashSet<>();
        int[][] swapIdx = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j]);
            }
        }
        String s = sb.toString();
        if (s.equals(ans)) {
            return 0;
        }

        int rst = 0;
        LinkedList<String> queue = new LinkedList<>();
        queue.addLast(s);
        marked.add(s);

        while (!queue.isEmpty()) {
            rst++;
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                String curr = queue.removeFirst();
                int zeroIdx = curr.indexOf('0');
                for (int j : swapIdx[zeroIdx]) {
                    String next = swap(curr, zeroIdx, j);
                    if (marked.contains(next)) {
                        continue;
                    }
                    if (next.equals(ans)) {
                        return rst;
                    }
                    marked.add(next);
                    queue.addLast(next);
                }
            }
        }
        return -1;
    }

    private static String swap(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);
        char tmp = s.charAt(i);
        sb.setCharAt(i, s.charAt(j));
        sb.setCharAt(j, tmp);
        return sb.toString();
    }
}
