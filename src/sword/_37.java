package sword;

/**
 * https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=13&tqId=11187&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 *
 * @author Radon Freedom
 * created at 2019.02.06 9:54
 */

public class _37 {

    private class Entry {
        Character c;
        Integer i;

        public Entry(Character c, Integer i) {
            this.c = c;
            this.i = i;
        }
    }

    public int FirstNotRepeatingChar(String str) {

        char[] chars = str.toCharArray();
        Entry[] entries = new Entry[str.length()];
        int index = -1;

        for (char c : chars) {
            int i;
            for (i = 0; i <= index; i++) {
                if (entries[i].c == c) {
                    entries[i].i++;
                    break;
                }
            }
            if (i == index + 1) {
                index++;
                entries[index] = new Entry(c, 1);
            }
        }

        Character result = null;
        for (int i = 0; i <= index; i++) {
            if (entries[i].i == 1) {
                result = entries[i].c;
                break;
            }
        }

        if (result != null) {
            return str.indexOf(result);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        new _37().FirstNotRepeatingChar("google");
    }
}
