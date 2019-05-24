package ctrip;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Radon Freedom
 * created at 2019.04.08 下午7:02
 */

public class _1 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        HashSet<String> set = new HashSet<>();
        String[] strings = in.next().split(",");
        for (String s : strings) {
            if (set.contains(s)) {
                System.out.println(true);
                return;
            }
            else {
                set.add(s);
            }
        }

        System.out.println(false);
    }
}
