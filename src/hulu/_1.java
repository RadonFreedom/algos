package hulu;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Shaman
 * @date 2019/9/5 19:04
 */

public class _1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        int[] w = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();
        }
        int wSum = 0;
        for (int i = 0; i < w.length; i++) {
            w[i] = in.nextInt();
            wSum += w[i];
        }

        double rst = 0;
        // 从i开始报数
        for (int i = 0; i < n; i++) {
            int winnerIdx = getWinner(n, m, i);
            if (a[winnerIdx] == 1) {
                rst += w[i];
            }
        }

        System.out.printf("%.5f", rst / wSum);
    }

    private static int getWinner(int n, int m, int begin) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int index = (m - 1 + begin) % n;
        while (list.size() > 1) {
            list.remove(index);
            index = (index + m - 1) % list.size();
        }

        return list.get(0);
    }
}

