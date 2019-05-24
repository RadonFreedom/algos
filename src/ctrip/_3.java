package ctrip;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Radon Freedom
 * created at 2019.04.08 下午8:09
 */

public class _3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();

        int cnt = in.nextInt();

        for (int i = 0; i < cnt; i++) {
            String s = in.next();
            if (s.endsWith("/")) {
                s = s.substring(0, s.length() - 1);
            }

            String[] path = s.split("/");
            if (path.length <= 1) {
                continue;
            }
            if (path.length == 2) {
                System.out.print("1 ");
                continue;
            }
            if (path.length == 3) {
                System.out.print("11 ");
                continue;
            }

            if (map.containsKey(s)) {
                System.out.print(1);
                for (int j = 0; j < path.length - 3; j++) {
                    System.out.print(map.get(s) + 1);
                }
                System.out.print(1);
                map.put(s, map.get(s) + 1);
            }
            else {
                map.put(s, 1);
                for (int j = 0; j < path.length - 1; j++) {
                    System.out.print(1);
                }
            }
            System.out.print(" ");
        }
    }
}
