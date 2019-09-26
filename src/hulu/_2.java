package hulu;

import java.util.Scanner;

/**
 * @author Shaman
 * @date 2019/9/5 19:28
 */

public class _2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        long rst = 0;
        int[][] p = new int[n][n];
        for (int i = 0; i < n; i++) {
            p[i][i] = a[i];
            rst += p[i][i];
            rst %= 1000000007;
            for (int j = i + 1; j < n; j++) {
                p[i][j] = Math.max(p[i][j - 1], a[j]);
                rst += p[i][j];
                rst %= 1000000007;
            }
        }

        System.out.println(rst);
    }
}
