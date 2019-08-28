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
        LinkedList<String> l = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int[][] swapIdx = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j]);
            }
        }
        if (ans.equals(sb.toString())) {
            return 0;
        }
        l.add(sb.toString());
        marked.add(sb.toString());

        int res = 0;

        while (!l.isEmpty()) {
            res++;
            int cnt = l.size();
            for (int i = 0; i < cnt; i++) {
                String curr = l.removeFirst();
                int zeroIdx = curr.indexOf('0');
                for (int j : swapIdx[zeroIdx]) {
                    String s = swap(zeroIdx, j, curr);
                    if (ans.equals(s)) {
                        return res;
                    }
                    if (!marked.contains(s)) {
                        l.addLast(s);
                        marked.add(s);
                    }
                }
            }
        }

        return -1;
    }

    private static String swap(int i, int j, String s) {
        StringBuilder res = new StringBuilder(s);
        char tmp = s.charAt(i);
        res.setCharAt(i, s.charAt(j));
        res.setCharAt(j, tmp);
        return res.toString();
    }

    public static void main(String[] args) {
        slidingPuzzle(new int[][]{{1, 2, 3}, {4, 5, 0}});
    }
}
