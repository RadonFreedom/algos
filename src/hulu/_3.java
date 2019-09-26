package hulu;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Shaman
 * @date 2019/9/5 19:57
 */

public class _3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = in.nextInt();
            }
        }

        PriorityQueue<Path> queue = new PriorityQueue<>(Comparator.comparingInt(path -> path.cnt - path.i - path.j));
        queue.add(new Path(0, 0, 0));

        while (!queue.isEmpty()) {
            Path curr = queue.poll();
            int i = curr.i;
            int j = curr.j;
            int cnt = curr.cnt;
            if (i == n - 1 && j == n - 1) {
                System.out.println(cnt);
                return;
            }
            if (i < n - 1) {
                queue.add(new Path(i + 1, j, cnt + a[i + 1][j]));
            }
            if (j < n - 1) {
                queue.add(new Path(i, j + 1, cnt + a[i][j + 1]));
            }
        }
    }

    private static class Path {
        int i;
        int j;
        int cnt;

        Path(int i, int j, int cnt) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }
    }
}
