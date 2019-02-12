package sword;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7?tpId=13&tqId=11180&tPage=2&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.02.10 13:36
 */

public class _43 {

    private Set<String> set;
    private char[] chars;

    public ArrayList<String> Permutation(String str) {

        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }

        chars = str.toCharArray();

        int setSize = 1;
        for (int i = 1; i <= chars.length; i++) {
            setSize = setSize * chars.length;
        }
        set = new HashSet<>(setSize);

        addString(0);

        ArrayList<String> result = new ArrayList<>(set);
        result.sort(String::compareTo);
        return result;
    }

    private void addString(int begin) {

        // 到达字符串最后一个字符，添加此时的字符串
        if (begin == chars.length - 1) {
            set.add(new String(chars));
        }
        // 没有到达最后一个字符，将字符串遍历置换
        // 把置换后的子字符串添加到结果集中，并还原本递归层的字符串
        else {
            for (int i = begin; i < chars.length; i++) {
                swap(begin, i);
                addString(begin + 1);
                //还原本层的字符串
                swap(begin, i);
            }
        }
    }

    private void swap(int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
