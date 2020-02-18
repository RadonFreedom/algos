package leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Shaman
 * @date 2020/2/16 20:33
 */

public class _131 {
    List<List<String>> res = new LinkedList<>();
    Stack<String> stack = new Stack<>();
    boolean[][] dp;

    public List<List<String>> partition(String s) {
        dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                int l = j;
                int r = i;
                while (l < r) {
                    if (dp[l][r]) {
                        dp[j][i] = true;
                        break;
                    }
                    if (s.charAt(l) != s.charAt(r)) {
                        break;
                    }
                    l++;
                    r--;
                }
                if (l >= r) {
                    dp[j][i] = true;
                }
            }
        }
        dfs(0, s);
        return res;
    }

    private void dfs(int i, String s) {
        if (i == s.length()) {
            res.add(new ArrayList<>(stack));
        }
        for (int j = i; j < s.length(); j++) {
            if (dp[i][j]) {
                stack.push(s.substring(i, j+1));
                dfs(j+1, s);
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        new _131().partition("aab");
    }
}
