package leetcode;

/**
 * @author Radon Freedom
 * created at 2019.05.28 10:02
 */

public class _6 {


    public String convert(String s, int numRows) {

        if (numRows <= 1 || s == null || s.length() <= numRows) {
            return s;
        }

        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            builders[i] = new StringBuilder();
        }

        char[] chars = s.toCharArray();
        int l = numRows * 2 - 2;
        for (int i = 0; i < chars.length; i++) {
            if (i % l < numRows) {
                builders[i % l].append(chars[i]);
            } else {
                builders[l - i % l].append(chars[i]);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(builders[i]);
        }

        return result.toString();
    }
}
