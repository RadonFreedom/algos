package tool;

import java.util.Scanner;

/**
 * @author Radon Freedom
 * created at 2019.06.13 21:28
 */

public class ParseStringToPac {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        StringBuilder pac = new StringBuilder();
        while (in.hasNext()) {
            String s = in.next();
            pac.append("||");
            pac.append(s.substring(s.indexOf('.') + 1));
            pac.append("^\n");
        }

        System.out.println(pac.toString());
    }
}
