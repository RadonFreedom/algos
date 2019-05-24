package sword;

/**
 *
 * 反转单词序列
 *
 * https://www.nowcoder.com/practice/3194a4f4cf814f63919d0790578d51f3?tpId=13&tqId=11197&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * @author Radon Freedom
 * created at 2019.01.23 13:25
 */

public class _8 {

    public String ReverseSentence(String str) {

        if (str == null) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        int index;

        while (str.contains(" ")) {
            index = str.lastIndexOf(" ");
            stringBuilder.append(str.substring(index + 1));
            str = str.substring(0, index);
            stringBuilder.append(" ");
        }

        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        System.out.println(new _8().ReverseSentence("student. a am I"));
    }
}
