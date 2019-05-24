package ali;

import java.util.Scanner;

/**
 * @author Radon Freedom
 * created at 2019.04.18 下午4:36
 */

public class _1 {

    public static void main (String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println(reverse2(in.next()));
    }

    public static String reverse(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }

        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length() / 2; i++) {
            char c = chars[i];
            chars[i] = chars[s.length() - 1 - i];
            chars[s.length() - 1 - i] = c;
        }

        return new String(chars);
    }

    public static String reverse2(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }

        return reverse2(s.substring(s.length() / 2)) + reverse2(s.substring(0, s.length() / 2));
    }
}
