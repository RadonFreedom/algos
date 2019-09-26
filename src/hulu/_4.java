package hulu;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Shaman
 * @date 2019/9/5 20:38
 */

// DP
public class _4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int rst = 0;
        HashMap<Integer, Integer> idCnt = new HashMap<>();
    }
}
